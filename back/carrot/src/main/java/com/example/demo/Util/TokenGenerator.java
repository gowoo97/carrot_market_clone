package com.example.demo.Util;

import org.springframework.stereotype.Component;

import com.example.demo.entity.dto.MemberDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenGenerator {

	private static final String SECRET_KEY ="sdfnkjweh3289skg289hgkdh9gsdfkl";
	
	public String create(MemberDTO memberDTO) {
		
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS256,SECRET_KEY)
				.setSubject(memberDTO.getUserId())
				.compact();
	}
	
	public String validate(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
}
