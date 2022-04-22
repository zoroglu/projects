package com.mix.svc.user;

import com.ent.user.User;
import com.mix.svc.main.IBaseService;

public interface UserService extends IBaseService<User>{
	User getUserByUsernamePassword(String username, String password);
	User getUserByUsernameHashCode(String username, String hashCode);
}