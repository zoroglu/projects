package com.mix.svc.security;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SecurityServiceImpl implements Serializable, SecurityService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1666178077580158871L;

	@Override
	public void sendActivationMail(String mailAddress, String username, String activationHash) {
		final String fromUsername = "resahapp@gmail.com";
        final String fromPassword = "resah1992.";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(fromUsername, fromPassword);
               }
        }); 
        try {
               Message message = new MimeMessage(session);
               String content = "Sayın " + username+"; üyelik işleminiz başarılı bir şekilde işleme alınmıştır.\nKullanıcı Adınız: "
            		   + username +"\n"+
            		   "\nÜyeliğinizi tamamlamak için son adım olan aktivasyon işlemini tamamlamak için taklayınız:"
            		   + "\nhttp://localhost:8083/awesome-0.0.1-SNAPSHOT/rest/activation/accountActivaton?username="+ username+"&hash="+activationHash
            		   + "\n\nSaygılarımızla awesome..";
//             message.setFrom(new InternetAddress("test@test.com"));
               message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailAddress));
               message.setSubject("awesome Üyelik Aktivasyon");
               message.setText(content); 
               Transport.send(message);
        } catch (MessagingException ex) {
               throw new RuntimeException(ex);
        }
		
	}

	@Override
	public void sendWelcomeMail(String email, String userName) {
		final String fromUsername = "resahapp@gmail.com";
        final String fromPassword = "resah1992.";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(fromUsername, fromPassword);
               }
        }); 
        try {
               Message message = new MimeMessage(session);
               String content = "Sayın " + userName+"; bu eposta'yı awesome uygulamasında yapıyor olduğunuz kullanıcı kaydı sebebiyle alıyorsunuz."
               		+ " Bu işlem size ait bir işlem değilse lütfen bu mail'e itibar etmeyiniz."
            		   + "\n\nSaygılarımızla awesome..";
//             message.setFrom(new InternetAddress("test@test.com"));
               message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
               message.setSubject("awesome Üyelik işleminiz");
               message.setText(content); 
               Transport.send(message);
        } catch (MessagingException ex) {
               throw new RuntimeException(ex);
        }
		
	}

}
