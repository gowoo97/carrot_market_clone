package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MessageService;
import com.example.demo.entity.Message;
import com.example.demo.entity.dto.MessageVO;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@MessageMapping("/{roomNo}")
	@SendTo("/topic/{roomNo}")
	public MessageVO sendMessage(MessageVO messageVO,@DestinationVariable int roomNo) {
		messageService.saveMessage(messageVO, roomNo);
		return messageVO;
	}
	
	
	@GetMapping("/{roomNo}")
	public List<MessageVO> getMessages(@PathVariable(name = "roomNo") long roomNo){
		List<Message> a = messageService.getMessages(roomNo);
		List<MessageVO> result = new ArrayList<>();
		for(Message m : a) {
			result.add(new MessageVO(m.getSender(),m.getContent()));
		}
		
		return result;
		
	}
	
	
	
}
