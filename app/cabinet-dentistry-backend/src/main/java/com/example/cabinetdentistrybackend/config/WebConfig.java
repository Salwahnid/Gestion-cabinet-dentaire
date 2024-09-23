package com.example.cabinetdentistrybackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:4200") // Utiliser allowedOriginPatterns
                .allowedMethods("POST", "GET", "PUT", "DELETE", "PATCH")
                .allowCredentials(true);
    }
}
