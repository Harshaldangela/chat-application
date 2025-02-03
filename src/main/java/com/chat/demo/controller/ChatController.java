package com.chat.demo.controller;

import com.chat.demo.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        // Add basic validation
        if (message.getSender() == null || message.getContent() == null) {
            throw new IllegalArgumentException("Sender and content must not be null");
        }
        return message;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}
