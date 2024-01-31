package com.example.demo.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AuthService;
import com.example.demo.entity.dto.MemberDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody MemberDTO memberDTO) {
		HashMap<String,Object> hm=new HashMap<>();
		
		if(authService.signup(memberDTO)) {
			System.out.println("회원가입 성공!");
			hm.put("register_stat",true);
		}
		else {
			System.out.println("회원가입 실패!");
			hm.put("register_stat",false);
			
		}
		return ResponseEntity.ok(hm);
		
	}
	
	@PostMapping("/signin")
	public void signin(MemberDTO memberDTO) {
		
		
		
	}
	
	
}
