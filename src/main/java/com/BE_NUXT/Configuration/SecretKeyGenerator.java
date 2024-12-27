package com.BE_NUXT.Configuration;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
	
	public static String generateSecretKey() {
		SecureRandom random = new SecureRandom();
		byte[] key = new byte[32]; // 256 bits
		random.nextBytes(key);
		return Base64.getEncoder().encodeToString(key);
	}
	

}
