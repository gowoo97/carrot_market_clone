package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.Util.TokenGenerator;
import com.example.demo.filter.JWTAuthFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private TokenGenerator tokenService;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().disable();
        http.httpBasic().disable();
        http.addFilterBefore(new JWTAuthFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
        
       
        
        http.authorizeRequests()
        	.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
        	.requestMatchers(HttpMethod.GET,"/item/**").permitAll()
        	.requestMatchers("/images/**").permitAll()
        	.requestMatchers("/auth/**").permitAll()
        	.anyRequest().authenticated();
         
        return http.build();
    }
	
}
