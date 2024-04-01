package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.Service.MessageService;
import com.example.demo.entity.dto.MessageVO;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@MessageMapping("/{roomNo}")
	@SendTo("/topic/{roomNo}")
	public MessageVO sendMessage(MessageVO messageVO,@DestinationVariable int roomNo) {
		messageService.saveMessage(messageVO, roomNo);
		return messageVO;
	}
}
