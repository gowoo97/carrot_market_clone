package com.example.demo.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.dto.MessageVO;

@Controller
public class MessageController {

	@MessageMapping("/{roomNo}")
	@SendTo("/topic/{roomNo}")
	public MessageVO sendMessage(MessageVO messageVO) {
		return messageVO;
	}
}
