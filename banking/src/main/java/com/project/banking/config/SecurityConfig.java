package com.project.banking.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.project.banking.filters.JwtAuthenticationFilter;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for configuring the security settings of the application.
 * It includes setting up CORS, authentication providers, and authorization rules.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    /**
     * The JWT authentication filter used for authenticating requests.
     */
    private final JwtAuthenticationFilter authFilter;

    /**
     * The authentication provider used for authenticating users.
     */
    private final AuthenticationProvider authenticationProvider;

    /**
     * Comma-separated list of allowed origins from environment variable
     * Defaults to localhost:3000 if not set
     */
    @Value("${corsAllowedOrigins:http://localhost:3000}")
    private String allowedOrigins;

    /**
     * Configures the security filter chain for the application.
     *
     * @param http The HttpSecurity object used to configure security settings.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors((c) -> c.configurationSource(corsConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                    request ->
                    request.requestMatchers("/user/auth", "/user/register")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    /**
     * Configures the CORS settings for the application.
     *
     * @return The configured CorsConfigurationSource.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        
        // Parse allowed origins from environment variable
        // Split by comma and trim whitespace
        List<String> origins = Arrays.asList(allowedOrigins.split(","));
        origins = origins.stream()
                        .map(String::trim)
                        .filter(origin -> !origin.isEmpty())
                        .toList();
        
        System.out.println("CORS Allowed Origins: " + origins); // For debugging
        
        corsConfig.setAllowedOrigins(origins);
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }
}