package com.example.demo.entity.dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
	
	private String userId;
	
	 
	private String password;
	

	private String profile;
	
	
	public Member toEntity() {
		return Member.builder()
				.userId(this.userId)
				.password(this.password)
				.profile(this.profile)
				.build();
	}
	
}
