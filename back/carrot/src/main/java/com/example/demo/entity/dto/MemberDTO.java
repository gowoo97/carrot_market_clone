package com.example.demo.entity.dto;

import java.util.ArrayList;
import java.util.List;

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
	
	
	private List<MemberDTO> friendList=new ArrayList<>();
	
	
	public Member toEntity() {
		return Member.builder()
				.userId(this.userId)
				.password(this.password)
				.profile(this.profile)
				.build();
	}
	
}
