package com.nautiDevelopers.Todo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated());

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // For Stateless REST API or Stateless Session
        http.sessionManagement(
                session -> session.sessionCreationPolicy
                        (SessionCreationPolicy.STATELESS));

        // disable Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

// Note: Go to postman, authorization and Basic Auth:
