package com.BE_NUXT.Configuration;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	
	private static final String SECRET_KEY= SecretKeyGenerator.generateSecretKey();
	
	public String generateToken(String username) {
		return Jwts.builder()
					.setSubject(username)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000)) // 1 heure
					.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
					.compact();
	}
	
	public static String validateToken(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody(); // Extract the claims
		return claims.getSubject();
	}
	
	public static boolean checkValidateToken(String token) {
	    try {
	        Claims claims = Jwts.parser()
	                .setSigningKey(SECRET_KEY)
	                .parseClaimsJws(token)
	                .getBody(); // Extract the claims

	        // If claims are successfully extracted, check if the subject is not null
	        return claims.getSubject() != null;
	    } catch (Exception e) {
	        // In case of any exception (e.g., invalid token), return false
	        return false;
	    }
	}

}
