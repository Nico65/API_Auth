package com.BE_NUXT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BE_NUXT.Configuration.SecretKeyGenerator;

@SpringBootApplication
public class BeNuxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeNuxtApplication.class, args);
		
		// String Secret_key = SecretKeyGenerator.generateSecretKey();
		
		// System.out.println("SECRET_KEY = "+ Secret_key);
	}

}
