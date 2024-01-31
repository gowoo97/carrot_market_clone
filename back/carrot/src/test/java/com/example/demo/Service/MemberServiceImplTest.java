package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.entity.Member;

@SpringBootTest
class MemberServiceImplTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void testInsertMember() {
		Member member=Member.builder().userId("user1").password("1234").build();
		memberRepository.save(member);
		assertEquals(member.getUserId(),"user1");
	}

	@Test
	void testGetMember() {
		
		memberRepository.save(Member.builder().userId("user1").password("1234").build());
		
		String userId="user1";
		
		Member member=memberRepository.findByUserId(userId);
		
		assertEquals(member.getUserId(),userId);
	}

}
