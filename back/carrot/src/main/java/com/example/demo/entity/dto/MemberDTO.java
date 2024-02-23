package com.example.demo.entity.dto;

import com.example.demo.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
