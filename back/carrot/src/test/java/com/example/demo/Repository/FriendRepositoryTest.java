package com.example.demo.Repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Friend;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FriendRepositoryTest {

	
	@Autowired
	private FriendRepository friendRepository;
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	@BeforeEach 
	public void setup() {
		Member member1=new Member();
		member1.setUserId("user1");
		
		Member member2=new Member();
		member2.setUserId("user2");
		
		Member member3=new Member();
		member3.setUserId("user3");
		
		
		memberRepository.save(member1);
		memberRepository.save(member2);
		memberRepository.save(member3);
		
		
		Friend friend1=new Friend();
		friend1.setFrom(member2);
		friend1.setTo(member1);
		friendRepository.save(friend1);
		
		Friend friend2=new Friend();
		friend2.setFrom(member3);
		friend2.setTo(member1);
		friendRepository.save(friend2);
		
		
		
	}
	
	@Test
	@Transactional
	public void 친구_목록_불러오기() {
		Member member = memberRepository.findByUserId("user1");
		System.out.println(member);
		
		List<Friend> list=friendRepository.getFriendsByUserId(member.getSeq());
		
		for(Friend f : list) {
			System.out.println(f);
		}
	}
	
	

}
