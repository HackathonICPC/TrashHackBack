package org.example.trashhackback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Disable CORS
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("*") // Allow all origins
                .allowedMethods("*") // Allow all methods
                .allowedHeaders("*"); // Allow all headers
    }
}