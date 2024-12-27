package com.BE_NUXT.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("*") // Autorise toutes les routes
			.allowedOrigins("*") // Remplace par l'URL de ton application
			.allowedMethods("*")
			.allowedHeaders("*")
			.allowCredentials(true);
	}
	
}
