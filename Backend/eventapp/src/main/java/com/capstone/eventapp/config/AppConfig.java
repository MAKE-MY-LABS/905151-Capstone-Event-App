package com.capstone.eventapp.config;

// create AppConfig class and annotate with @Configuration and create Bean for RestTemplate

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

/**
 * This class represents the configuration for the application.
 */
public class AppConfig {
    /**
     * Returns a new instance of the RestTemplate class.
     *
     * @return a new RestTemplate instance
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
