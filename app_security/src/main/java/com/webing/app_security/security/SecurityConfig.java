package com.webing.app_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((peticiones) -> peticiones
                .requestMatchers("/welcome/**","/aboutus/**","/v3/api-docs/**",
                "/swagger-ui/**", "/swagger-ui.html").permitAll() // Deja pasar a todos aquí
                .anyRequest().authenticated()           // El resto requiere login
            )
            .formLogin(Customizer.withDefaults())        // Habilita el formulario visual
            .httpBasic(Customizer.withDefaults());      // Habilita autenticación básica para Postman
        return http.build();
    }
}