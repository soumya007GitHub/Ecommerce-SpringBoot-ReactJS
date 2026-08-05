package com.soumya.ecommerce.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppConfig {

    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.sessionManagement(
                management -> management.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                )
        ).authorizeHttpRequests(authorize-> {
            authorize.requestMatchers("/api/**").authenticated()
            .requestMatchers("/api/products/*/reviews").permitAll()
                    .anyRequest().permitAll();

        }).addFilterBefore((Filter) new JwtTokenValidator(), BasicAuthenticationFilter.class);
                return null;
    }
}
