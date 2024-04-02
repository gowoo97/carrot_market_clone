package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
	
	
		@Query(
					"SELECT m from Message m join fetch m.room "
					+ "where m.room.id = :room_id"
				)
		List<Message> findByRoomId(@Param("room_id") long roomNo);
		
}
