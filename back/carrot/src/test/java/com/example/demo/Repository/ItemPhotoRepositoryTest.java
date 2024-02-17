package com.example.demo.Repository;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemPhoto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemPhotoRepositoryTest {

	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemPhotoRepository itemPhotoRepository;
	
	private Item item;
	
	@BeforeEach
	public void setUp() {
		item=Item.builder().title("자전거").price(100000).place("서울").content("팝니다.").build();
		itemRepository.save(item);
		System.out.println(item.toString());
	}
	
	@Test
	public void itemPhoto_저장하기_테스트() {
		
		ItemPhoto itemPhoto=ItemPhoto.builder().fileName("자전거.jpg").item_id(item).build();
		ItemPhoto savedItemPhoto=itemPhotoRepository.save(itemPhoto);
		
		assertEquals(item,itemPhoto.getItem_id());
		assertEquals(itemPhoto.getFileName(),"자전거.jpg");
	}
	
}
