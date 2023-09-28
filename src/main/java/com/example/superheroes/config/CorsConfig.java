package com.example.superheroes.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

    @Bean
    CorsFilter corsFilter() {
        return new CorsFilter();
    }
}
