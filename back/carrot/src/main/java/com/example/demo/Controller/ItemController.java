package com.example.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.ItemService;
import com.example.demo.entity.Item;
import com.example.demo.entity.dto.ItemDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public void addItem(@RequestPart("itemDTO") ItemDTO itemDTO,
			@RequestPart(value = "images",required = false) MultipartFile[] files) throws IOException {
		
		itemService.addItem(files,itemDTO);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> getItems(@RequestParam(name = "count") int count) {
		
		Page<Item> pages=itemService.getItems(count);
		
		List<ItemDTO> items=new ArrayList<>();
		
		for(Item item:pages.getContent()){
			items.add(item.toDTO());
		}
		
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/{id}")
	public ItemDTO getItem(@PathVariable(name = "id") Long id) {
		Item item=itemService.getItem(id);
		
		return item.toDTO();
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable(name = "id") Long id) {
		
		
		itemService.deleteItem(id);
		
	}
	
	
}
