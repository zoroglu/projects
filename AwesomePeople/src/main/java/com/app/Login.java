package com.app;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.annotations.matching.AweLog;
import com.annotations.matching.LoggedIn;
import com.aws.util.SecurityUtils;
import com.ent.user.User;
import com.mix.svc.user.UserService;

//kaynak ******* https://docs.jboss.org/cdi/spec/1.2/cdi-spec.html
//@Model: İçerisinde @Named ve @RequestScoped i barındıran @SteroeType la işaretlenmiş, javax.enterprise.inject; altında bulunan özel bir notasyondur. mvc yapısının model katmanını tanımlayan
// beanlerde kullanılmak amaçlı oluşturulmuş.
@SessionScoped
@Model
public class Login implements Serializable {

	private static final long serialVersionUID = -8272904499932604017L;

	@Inject
	Credentials credentials;

	private User currentUser;

	@Inject
	private UserService userService;
	
	@Inject
	@AweLog
	Logger logger;

	public String login() {
		this.clearUser();
		if (validateCredentials(credentials.getUserName(), credentials.getPassword())) {
			String md5Password = SecurityUtils.generateMD5(credentials.getPassword());
			User result = userService.getUserByUsernamePassword(credentials.getUserName(), md5Password);
			if (result != null && result.isActive()) {
				currentUser = result;
				logger.info(currentUser.getEmail() + " - " + currentUser.getUserName() + " logged in");
				return "userMain.xhtml?faces-redirect=true";
			} else if (result != null && !result.isActive()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "",
						"Hesabınız aktif değildir! Lütfen E-Postanıza gelen aktivasyon linkine tıklayarak hesabınızı doğrulayınız."));
			} else {
				User hasUsername = userService.getUserByUsernamePassword(credentials.getUserName(), null);

				if (hasUsername != null) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "",
							"Lütfen Şifrenizi doğru girdiğinizden emin olunuz!"));
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "",
							"Girdiğiniz Kullanıcı Adına Ait Hesap bulunamadı!"));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Kullanıcı adı veya şifre girmediniz!"));
		}
		return "";//hata durumunda burayı boş geçip mesaj yayınlanmasını sağlamak
	}

	public String logout() {
		currentUser = null;
		return "userMain.xhtml?faces-redirect=true";
	}

	public void redirectSignPage() {
		    try {
		    	FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8083/awesome-0.0.1-SNAPSHOT/user/signUpPage.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public boolean isLoggedIn() {
		return currentUser != null;
	}

	@Produces
	@LoggedIn // baseCB de de bu notasyonu kullanıp, bana login kullanıcıyı bu methodla döndür
				// diyoruz
	public User getCurrentUser() {
		if (currentUser == null) {
			return null;
		} else {
			return currentUser;
		}
	}

	private void clearUser() {
		this.currentUser = null;
	}

	private boolean validateCredentials(String username, String password) {
		if (username == null || password == null || username.length() < 3) {
			return false;
		}
		return true;
	}

}
