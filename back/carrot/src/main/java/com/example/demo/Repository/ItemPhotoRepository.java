package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemPhoto;

public interface ItemPhotoRepository extends JpaRepository<ItemPhoto,Long>{
	
}
