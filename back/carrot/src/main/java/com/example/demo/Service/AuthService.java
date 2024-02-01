package com.example.demo.Service;

import com.example.demo.entity.dto.MemberDTO;

public interface AuthService {

	public String signin(MemberDTO memberDTO);
	
	
	public boolean signup(MemberDTO memberDTO);
	
}
