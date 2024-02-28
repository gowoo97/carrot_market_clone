package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.dto.ItemDTO;
import com.example.demo.entity.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name ="price")
	private int price;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "place")
	private String place;
	
	@OneToMany(mappedBy = "item_id" , fetch = FetchType.LAZY)
	private List<ItemPhoto> photos=new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member publisher;
	
	@Column(name = "visit")
	private long visit;
	
	public ItemDTO toDTO() {
			ItemDTO itemDTO=ItemDTO.builder().id(this.id).title(this.title).price(this.price).content(this.content).place(this.place)
			.photos(new ArrayList<>()).publisher(new MemberDTO()).visit(this.visit).build();
		
		for(ItemPhoto photo : this.photos) {
			itemDTO.getPhotos().add(photo.getFileName());
		}
		
		itemDTO.getPublisher().setUserId(publisher.getUserId());
		itemDTO.getPublisher().setProfile(publisher.getProfile());
		
		
		return itemDTO;
			
	}
	
}
