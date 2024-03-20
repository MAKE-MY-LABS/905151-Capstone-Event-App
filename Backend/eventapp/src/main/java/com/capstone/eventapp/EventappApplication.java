package com.capstone.eventapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The main class for the Eventapp application.
 * This class is responsible for starting the application and configuring CORS
 * (Cross-Origin Resource Sharing) settings.
 */
@SpringBootApplication
public class EventappApplication {

	/**
	 * The main entry point for the Eventapp application.
	 * This method starts the Spring Boot application.
	 *
	 * @param args The command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EventappApplication.class, args);
	}

	// add bean for all cors for all origins, all methods

	/**
	 * Defines callback methods to customize the Java-based configuration for Spring
	 * MVC.
	 * Implementations of this interface can be used to customize the behavior of
	 * the
	 * {@link org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport}.
	 * 
	 * <p>
	 * The {@link #addCorsMappings(CorsRegistry)} method allows configuring
	 * Cross-Origin
	 * Resource Sharing (CORS) mappings for the application. CORS defines a way in
	 * which a
	 * browser and server can interact to determine whether or not it is safe to
	 * allow the
	 * cross-origin request.
	 * 
	 * <p>
	 * Implementations of this interface should be registered as beans in the Spring
	 * application context.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
