package com.example.demo.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Item;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepository;

	@Test
	public void item_저장하기() {
		
		Item item=Item.builder()
				.title("자전거")
				.price(100000)
				.place("서울")
				.content("팝니다.")
				.build();
		
		Item savedItem= itemRepository.save(item);
		
		Assertions.assertEquals(itemRepository.findById(savedItem.getId()).get(),savedItem);
		
	}
	
}
