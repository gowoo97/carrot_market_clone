package com.example.demo.Service;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Item;
import com.example.demo.entity.dto.ItemDTO;

public interface ItemService {

	
	public Item addItem(MultipartFile[] files,ItemDTO itemDTO) throws IOException;
	
	public Page<Item> getItems(int count);
	
	public Item getItem(Long id);
	
	
	public void deleteItem(Long id);
	
	public void modifyItem(Long id, ItemDTO itemDTO);
}
