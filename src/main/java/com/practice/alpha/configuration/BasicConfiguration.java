package com.practice.alpha.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "/api/products")
                        .hasAuthority("SCOPE_edit_product")
                        .requestMatchers(HttpMethod.PATCH, "/api/products/{productsId:\\d+}")
                        .hasAuthority("SCOPE_edit_product")
                        .requestMatchers(HttpMethod.DELETE, "/api/products/{productsId:\\d+}")
                        .hasAuthority("SCOPE_edit_product")
                        .requestMatchers(HttpMethod.GET)
                        .hasAuthority("SCOPE_view_product")
                        .anyRequest()
                        .permitAll())
                .csrf(CsrfConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oAuth2UserService -> oAuth2UserService
                        .jwt(Customizer.withDefaults()))
                .build();
    }
    
}
