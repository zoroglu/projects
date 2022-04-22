package com.app;

import javax.enterprise.inject.Model;

//bu sınıfın yaşam döngüsü bir jsf sayfasının request ine bağlanmıştır.
//ince nokta  - benim anladığım bu class ın var oluş sebebi login olurken o anki request edilen sayfadaki
//username ve passwordun kullanıldığına emin olmak!
@Model
public class Credentials {

	private String userName;
	private String password;

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
}
