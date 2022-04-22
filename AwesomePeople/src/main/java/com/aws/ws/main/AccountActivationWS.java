package com.aws.ws.main;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.annotations.matching.TheBaseService;
import com.aws.cb.userjob.SignUpCB;
import com.ent.user.User;
import com.mix.svc.main.IBaseService;
import com.mix.svc.user.UserService;

@Path("/activation")
public class AccountActivationWS {
	
	@Inject
	@TheBaseService
	private IBaseService baseService;
	
	@Inject
	private UserService userService;
		
	@Inject
	private SignUpCB signUpCB;
	/**
	 * Üye olan kullanıcının hesabını aktifleştirme Web servisi, Kullanıcı üye olduktan sonra üyelik bilgileriyle birlikte gönderilen URL'den gelen istekleri karşılar
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/accountActivaton")
	public Response accountActivaton(@QueryParam(value = "username") String username,@QueryParam(value = "hash") String hash) {
		User user = userService.getUserByUsernameHashCode(username, hash);
		URI uri = null;
		if(user != null && user.isActive() != true){
			user.setActive(true);
			baseService.update(user);			
		}
		try {
			uri = new URI("../userMain.xhtml");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.temporaryRedirect(uri).build();
	}
}
