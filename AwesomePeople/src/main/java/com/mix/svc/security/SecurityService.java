package com.mix.svc.security;

public interface SecurityService {
	void sendActivationMail(String mailAddress, String username, String activationHash);
	void sendWelcomeMail(String email, String userName);
}
