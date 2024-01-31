package com.example.demo.Service;

import com.example.demo.entity.dto.MemberDTO;

public interface AuthService {

	public boolean signin(MemberDTO memberDTO);
	
	
	public boolean signup(MemberDTO memberDTO);
	
}
