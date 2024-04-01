package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@JoinColumn(name = "room_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Room room;
	
	@Column
	private String sender;
	
	@Column
	private String content;
	
	@CreationTimestamp
	@Column(name = "creation_date")
	private LocalDateTime insDate;
	
}
