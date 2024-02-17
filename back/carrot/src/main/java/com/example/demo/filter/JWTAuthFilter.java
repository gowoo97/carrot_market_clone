package com.example.demo.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.Util.TokenGenerator;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter{

	private final TokenGenerator tokenGenerator;

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = parseBearerToken(request);
			if(token != null && !token.equalsIgnoreCase("null")) {
				String user=tokenGenerator.validate(token);
				System.out.println(user);
				UsernamePasswordAuthenticationToken authentication
				= new UsernamePasswordAuthenticationToken(user,null,AuthorityUtils.NO_AUTHORITIES);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
		}catch(Exception ex) {
			
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	
	
	
	private String parseBearerToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}








	
}
