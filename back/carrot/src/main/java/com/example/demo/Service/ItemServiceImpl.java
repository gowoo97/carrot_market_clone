package com.example.demo.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.ItemPhotoRepository;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemPhoto;
import com.example.demo.entity.Member;
import com.example.demo.entity.dto.ItemDTO;

import jakarta.transaction.Transactional;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemPhotoRepository itemPhotoRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	@Transactional
	public Item addItem(MultipartFile[] files,ItemDTO itemDTO) throws IOException {
		
		String userId= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Member publisher = memberRepository.findByUserId(userId);
		
		Item item = Item.builder().title(itemDTO.getTitle()).price(itemDTO.getPrice()).content(itemDTO.getContent())
				.place(itemDTO.getPlace()).publisher(publisher).build();
		
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

	@Override
	public Page<Item> getItems(int count) {
		return itemRepository.findAll(PageRequest.of(0,count));
	}

	@Override
	@Transactional
	public Item getItem(Long id) {
		Item item =itemRepository.findById(id).get();
		item.setVisit(item.getVisit()+1);
		return item; 
	}

	
	
	

}
