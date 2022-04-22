package com.mix.dao.user;

import com.ent.user.User;

public interface UserDao {
	User getUserByUsernamePassword(String username, String password);
	User getUserByUsernameHashCode(String username, String hashCode);
}
