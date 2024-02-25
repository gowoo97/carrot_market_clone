package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.FriendRepository;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.entity.Friend;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private FriendRepository friendRepository;
	
	@Transactional
	@Override
	public Friend addFriend(String userId1, String userId2) {
		
			Member member1=memberRepository.findByUserId(userId1);
			Member member2=memberRepository.findByUserId(userId2);
			
			Friend friend=Friend.builder().from(member1).to(member2).build();
	
			friendRepository.save(friend);
		
		
		
		return friend;
	}

}
