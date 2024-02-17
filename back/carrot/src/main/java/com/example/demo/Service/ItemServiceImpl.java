package com.example.demo.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.ItemPhotoRepository;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemPhoto;
import com.example.demo.entity.dto.ItemDTO;

import jakarta.transaction.Transactional;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemPhotoRepository itemPhotoRepository;

	@Override
	@Transactional
	public Item addItem(MultipartFile[] files,ItemDTO itemDTO) throws IOException {
		
		Item item = Item.builder().title(itemDTO.getTitle()).price(itemDTO.getPrice()).content(itemDTO.getContent())
				.place(itemDTO.getPlace()).build();
		
		itemRepository.save(item);
		
		for(MultipartFile file:files) {
			UUID uuid=UUID.randomUUID();
			file.transferTo(Paths.get("src/main/resources/static/images/"+uuid.toString()+"_"+file.getOriginalFilename()));
			ItemPhoto itemPhoto=ItemPhoto.builder().fileName(uuid.toString()+"_"+file.getOriginalFilename())
			.item_id(item).build();
			itemPhotoRepository.save(itemPhoto);
		}
		return item;
	}

}
