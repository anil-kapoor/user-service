package com.example.userservice.config;

import com.example.userservice.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/v1/users/**").hasAnyRole("PLATFORM_ADMIN", "SUPPORT")
                        .requestMatchers("/api/v1/theatres/**").hasAnyRole("THEATRE_ADMIN", "PLATFORM_ADMIN")
                        .requestMatchers("/api/v1/movies/**").hasAnyRole("PLATFORM_ADMIN", "SUPPORT")
                        .requestMatchers("/api/v1/showtimes/**").hasAnyRole("THEATRE_ADMIN", "PLATFORM_ADMIN")
                        .requestMatchers("/api/v1/seat-inventory/**").hasAnyRole("THEATRE_ADMIN", "PLATFORM_ADMIN")
                        .requestMatchers("/auth/token", "/swagger-ui.html", "/v3/api-docs/**", "/actuator/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(new JwtAuthConverter()))
                );
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withSecretKey(JwtUtil.getSecretKey()).build();
    }
}