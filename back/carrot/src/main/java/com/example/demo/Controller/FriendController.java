package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FriendService;
import com.example.demo.entity.Friend;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	@PostMapping
	public ResponseEntity<?> addFriend(@RequestBody Map<String,String> param){
		
		String from=SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Friend friend=friendService.addFriend(from, param.get("to"));
		
		
		return ResponseEntity.ok(friend);
	}
	
	
}
