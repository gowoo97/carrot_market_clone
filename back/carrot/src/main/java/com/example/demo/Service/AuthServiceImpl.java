package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.Util.TokenGenerator;
import com.example.demo.entity.Member;
import com.example.demo.entity.dto.MemberDTO;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private TokenGenerator tokenGenerator;
	
	@Override
	public String signin(MemberDTO memberDTO) {
		
		Member member=memberRepository.findByUserId(memberDTO.getUserId());
		
		if(member == null) {
			return null;
		}
		
		if(validateMember(memberDTO,member)) {
			return tokenGenerator.create(memberDTO);
		}
		
		return null;
	}

	@Override
	public boolean signup(MemberDTO memberDTO) {
		
		Member exist=memberRepository.findByUserId(memberDTO.getUserId());
		
		//이미 존재하는 멤버이면 거절
		if(exist!=null) {
			return false;
		}
		else {
			System.out.println(memberDTO.getUserId());
			memberRepository.save(memberDTO.toEntity());
			return true;
		}
	}
	
	
	private boolean validateMember(MemberDTO memberDto, Member member) {
		if(member.getUserId().equals(memberDto.getUserId()) &&
				member.getPassword().equals(memberDto.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

}
