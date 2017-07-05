package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.itis.models.Message;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/chat/")
    public void getMessage(Message message) {
        System.out.println("Get message " + message.getText() +  " from " + message.getFrom());
        template.convertAndSend("/topic/messages", new Message("server", message.getText()));
    }
}
