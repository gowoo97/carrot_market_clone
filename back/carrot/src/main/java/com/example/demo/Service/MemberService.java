package com.example.demo.Service;

import com.example.demo.entity.Member;

public interface MemberService {

	
	public void insertMember(Member member);
	
	public Member getMember(String userId);
	
}
