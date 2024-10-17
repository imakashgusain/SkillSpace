package com.project.SkillSpace.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors() // Enable CORS
                .and()
                .csrf().disable() // Disable CSRF for simplicity (optional)
                .authorizeHttpRequests((auth) -> auth
                        .anyRequest().permitAll() // Allow all requests without authentication
                );
        return http.build();
    }
}

