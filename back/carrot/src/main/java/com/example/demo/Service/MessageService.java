package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MessageRepository;
import com.example.demo.Repository.RoomRepository;
import com.example.demo.entity.Message;
import com.example.demo.entity.Room;
import com.example.demo.entity.dto.MessageVO;

import jakarta.transaction.Transactional;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Transactional
	public void saveMessage(MessageVO message,long roomNo) {
		Message messageEntity = new Message();
		Room room= roomRepository.findById(roomNo).get();
		messageEntity.setRoom(room);
		messageEntity.setSender(message.getUserName());
		messageEntity.setContent(message.getContent());
		messageRepository.save(messageEntity);
	}
	
}
