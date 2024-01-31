package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.entity.Member;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void insertMember(Member member) {
		
		memberRepository.save(member);

	}

	@Override
	public Member getMember(String userId) {
		return memberRepository.findByUserId(userId);
	}

}
