package com.mix.svc.user;

import java.io.Serializable;

import javax.inject.Inject;

import com.ent.user.User;
import com.mix.dao.user.UserDao;
import com.mix.svc.main.AbstractBaseService;

public class UserServiceImpl extends AbstractBaseService<User> implements UserService,Serializable{

	private static final long serialVersionUID = 4534748577713371784L;
	
	@Inject
	private UserDao userDao;

	@Override
	public User getUserByUsernamePassword(String username, String password) {
		return userDao.getUserByUsernamePassword(username, password);
	}

	@Override
	public User getUserByUsernameHashCode(String username, String hashCode) {
		return userDao.getUserByUsernameHashCode(username, hashCode);		
	}

}
