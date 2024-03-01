package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FriendService;
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
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping
	public ResponseEntity<?> findMemberByToken() {
		
		String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Member member =memberService.getMember(user);
		
		MemberDTO memberDTO =MemberDTO.builder().userId(user).profile(member.getProfile())
				.friendList(new ArrayList<>()).build();

		
		List<Friend> friends = friendService.getFriends(member.getSeq());
		
		for(Friend friend : friends ) {
			Member friendMember;
			if(member.getUserId().equals(friend.getFrom().getUserId())) {
				friendMember=friend.getTo();
			}
			else {
				friendMember=friend.getFrom();
			}
			
			ProfileDTO profile=new ProfileDTO(friendMember.getUserId(),friendMember.getProfile());
			
			memberDTO.getFriendList().add(profile);
			
		}
		
		
		
		return ResponseEntity.ok(memberDTO);
		
	}
	
	
}
