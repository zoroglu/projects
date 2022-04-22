package com.aws.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {
	
	public static String generateMD5(String password) {
		String md5 = null;
		if (password == null)
			return null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes(), 0, password.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
}
