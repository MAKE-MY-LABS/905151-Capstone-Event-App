package com.capstone.eventapp.config;

// create AppConfig class and annotate with @Configuration and create Bean for RestTemplate

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

