package com.example.demo.entity.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemDTO {

	private String title;
	private int price;
	private String content;
	private String place;
}
