package com.example.demo.Service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
	
	private static final String secretKey="jkv!$z%zo=nj6&kklo^&y!3f1n*9!pauwh89y1(_&z^3@*a3a&";
	
	public String create() {
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,1);
		
		Claims claims=Jwts.claims()
				.setSubject("access_token")
				.setIssuedAt(new Date())
				.setExpiration(new Date(cal.getTimeInMillis()));
		
		String jwt = Jwts.builder()
				.setHeaderParam("typ","JWT")
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256,secretKey.getBytes()).compact();
		
		return jwt;
	}
	
	public boolean checkClaim(String jwt) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(secretKey.getBytes())
					.parseClaimsJws(jwt).getBody();
			return true;
		}catch(ExpiredJwtException e) {
			return false;
		}catch(JwtException e) {
			return false;
		}
	}
	
	
	
}
