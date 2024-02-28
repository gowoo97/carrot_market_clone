package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MemberService;
import com.example.demo.entity.Friend;
import com.example.demo.entity.Member;
import com.example.demo.entity.dto.MemberDTO;
import com.example.demo.entity.dto.ProfileDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping
	public ResponseEntity<?> findMemberByToken() {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Member member =memberService.getMember(user);
		
		MemberDTO memberDTO =MemberDTO.builder().userId(user).profile(member.getProfile())
				.friendList(new ArrayList<>()).build();
		
		for(Friend friend : member.getFriendList()) {
			
			Member friendMember = friend.getTo();
			
			ProfileDTO profile=new ProfileDTO(friendMember.getUserId(),friendMember.getProfile());
			
			memberDTO.getFriendList().add(profile);
			
		}
		
		
		
		return ResponseEntity.ok(memberDTO);
		
	}
	
	
}
