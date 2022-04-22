package com.aws.cb.userjob;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.annotations.matching.AweLog;
import com.annotations.matching.TheBaseService;
import com.aws.util.SecurityUtils;
import com.ent.user.User;
import com.mix.svc.main.IBaseService;
import com.mix.svc.security.SecurityService;
import com.mix.svc.user.UserService;

@Model
public class SignUpCB implements Serializable {

	private static final long serialVersionUID = 786396253383220511L;

	@Inject
	private SecurityService securityService;
	
	@Inject
	private UserService userService;
	
	@Inject
	@TheBaseService
	private IBaseService baseService;
	
	@Inject 
	@AweLog
	Logger logger;
	
	private String userName;
	private String password;
	private String passwordConfirm;
	private String email;

	private User signingUpUser;

	public String signUp() {
		if (validateSignInfo(userName, password, passwordConfirm, email)) {
			try {
				securityService.sendWelcomeMail(email, userName);
			} catch (RuntimeException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Lütfen geçerli bir mail adresi giriniz!"));
				return null;
			} //yeni bir nesne oluşturmadan önce mail adresinin geçerliliğini kontrol edelim

			signingUpUser = new User();
			signingUpUser.setUserName(userName);
			signingUpUser.setPassword(SecurityUtils.generateMD5(password));
			signingUpUser.setEmail(email);
			signingUpUser.setActive(false);
			signingUpUser.setActivationHash(SecurityUtils.generateMD5(userName)); // kullanıcı adının hash halini
																					// aktivasyon kodu olarak kullanalım

			try {
				securityService.sendActivationMail(email, userName, SecurityUtils.generateMD5(userName));
			} catch (RuntimeException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
						"Aktivasyon kodunu gönderemedik :( Mail adresinizle ilgili bir sorun var!"));
				return null;
			}
			
			//kayıt burada gerçekleşiyor. kaydedilmesi gereken entity user olduğu belli oldugu için 
			//userservice kullanmak daha dinamik olur
			userService.save(signingUpUser);
			logger.info(" - " + signingUpUser.getEmail() + " successfully signed up.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Kayıt işleminiz gerçekleşti. Aktivasyon için mail adresinizi kontrol ediniz!"));
			clear();
			return "";
		}
		return "";
	}

	private boolean validateSignInfo(String userName, String password, String repassword, String email) {
		if (email == null || repassword == null || password  == null || userName == null 
				|| userName.length() < 3 || userName.length() > 20 || password.length() < 3 || password.length() > 20) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
					"Kullanıcı adı ve şifre min 3, max 20 karakter uzunluğunda olmalı"));
			return false;
		} else if (!passwordConfirm.equals(password)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Şifreler uyuşmuyor"));
			return false;
		}
		return true;
	}

	@PostConstruct // init metodunun bean çağrıldığı anda çalıştırılması için tanımlandı.
	public void init() {
		signingUpUser = new User();
	}
	
	private void clear() {
		signingUpUser = null;
		userName = null;
		password = null;
		passwordConfirm = null;
		email = null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getSigningUpUser() {
		return signingUpUser;
	}

	public void setSigningUpUser(User signingUpUser) {
		this.signingUpUser = signingUpUser;
	}
}
