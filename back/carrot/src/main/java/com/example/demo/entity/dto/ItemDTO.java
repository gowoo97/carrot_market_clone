package com.example.demo.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.ItemPhoto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ItemDTO {

	private long id;
	private String title;
	private int price;
	private String content;
	private String place;
	private List<String> photos=new ArrayList<>();
	private MemberDTO publisher;
	private long visit;
}
