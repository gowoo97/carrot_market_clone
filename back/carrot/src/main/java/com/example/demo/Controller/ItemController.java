package com.example.demo.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.ItemService;
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
	
}
