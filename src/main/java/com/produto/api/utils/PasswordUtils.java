package com.produto.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	
	private static BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	public static String generateBCrypt(String pass) {
		if (pass == null) {
			return pass;
		}
		 
		return bCryptEncoder.encode(pass);
	}
	
	public static boolean comparePassword(String rawPassword, String encodedPassword) {
		
		return bCryptEncoder.matches(rawPassword, encodedPassword);
		
	}

}
