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
import com.example.demo.entity.dto.FriendDTO;
import com.example.demo.entity.dto.MemberDTO;

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
		
		MemberDTO memberDTO= member.toDTO();
		memberDTO.setPassword("");
		memberDTO.setFriendList(new ArrayList<>());
		for(Friend friend : member.getFriendList()) {
			FriendDTO friendDTO =new FriendDTO(friend.getFrom().getUserId(),friend.getTo().getUserId());
			memberDTO.getFriendList().add(friendDTO);
		}
		
		return ResponseEntity.ok(memberDTO);
		
	}
	
	
}
