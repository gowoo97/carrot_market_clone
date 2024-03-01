package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "member" ,indexes = @Index(name="userId" , columnList="userId",unique = true))
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
