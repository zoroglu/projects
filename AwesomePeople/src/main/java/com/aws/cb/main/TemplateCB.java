package com.aws.cb.main;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.annotations.matching.LoggedIn;
import com.ent.user.User;

@Model
public class TemplateCB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2805831512865314046L;
	
	@Inject
	@LoggedIn
	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}
}
