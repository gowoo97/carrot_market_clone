package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().disable();
        http.httpBasic().disable();
        http.authorizeRequests()
        	.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
        	.requestMatchers("/auth/**").permitAll()
        	.requestMatchers("/api/**").authenticated()
        	.anyRequest().permitAll();

        return http.build();
    }
	
}
