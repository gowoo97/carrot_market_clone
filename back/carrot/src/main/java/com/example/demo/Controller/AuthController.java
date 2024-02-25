package com.example.demo.Controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.AuthService;
import com.example.demo.entity.dto.MemberDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(path = "/signup")
	public ResponseEntity<?> signup(@RequestPart(value = "memberDTO") MemberDTO memberDTO,
			@RequestPart(value = "profile",required = false) MultipartFile file) throws IOException {
		HashMap<String,Object> hm=new HashMap<>();
		UUID uuid=UUID.randomUUID();
		
		file.transferTo(Paths.get("src/main/resources/static/images/"+uuid.toString()+"_"+file.getOriginalFilename()));
	
		memberDTO.setProfile(uuid.toString()+"_"+file.getOriginalFilename());
				
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
	public ResponseEntity<?> signin(@RequestBody MemberDTO memberDTO) {
		
		String token = authService.signin(memberDTO);
		
		HashMap<String,String> hm=new HashMap<>();
		hm.put("token",token);
		if(token==null) {	
			return ResponseEntity.badRequest().body(hm);
		}
		else {
			return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,new HttpCookie("token",token).toString())
					.body(hm);
		}
		
	}
	
	
}
