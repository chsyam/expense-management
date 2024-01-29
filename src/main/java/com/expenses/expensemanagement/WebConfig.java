package com.expenses.expensemanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/transactions/get/all").allowedOrigins("http://localhost:3000").allowedMethods("GET")
				.allowCredentials(true);

		registry.addMapping("/users/get/all").allowedOrigins("http://localhost:3000").allowedMethods("GET")
				.allowCredentials(true);

		registry.addMapping("/transactions/save").allowedOrigins("http://localhost:3000").allowedMethods("POST")
				.allowCredentials(true);
		registry.addMapping("/transactions/get/all").allowedOrigins("https://chsyam.github.io").allowedMethods("GET")
				.allowCredentials(true);
		registry.addMapping("/users/get/all").allowedOrigins("https://chsyam.github.io").allowedMethods("GET")
				.allowCredentials(true);
		registry.addMapping("/transactions/save").allowedOrigins("https://chsyam.github.io").allowedMethods("POST")
				.allowCredentials(true);
	}
}
