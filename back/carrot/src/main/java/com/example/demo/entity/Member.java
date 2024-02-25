package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	@Column
	private String userId;
	
	@Column
	private String password;
	
	@Column
	private String profile;
	
	
	
	public MemberDTO toDTO() {
		return MemberDTO.builder()
				.userId(userId)
				.password(password)
				.profile(profile)
				.build();
	}
}
