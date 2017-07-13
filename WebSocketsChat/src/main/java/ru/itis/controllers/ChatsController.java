package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.ChatDto;
import ru.itis.dto.MessageDto;
import ru.itis.dto.UserDto;
import ru.itis.service.ChatService;

import java.util.List;

@Controller
public class ChatsController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    public ResponseEntity<List<ChatDto>> getChats() {
        return new ResponseEntity<>(chatService.getChats(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/chats")
    public ResponseEntity<Object> postChat(@RequestHeader("Auth-Token") String token, @RequestBody ChatDto chat) {
        chatService.addChat(chat, token);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("chats/{chat-id}")
    public ResponseEntity<Object> postUserToChat(@RequestBody UserDto userDto) {
        return null;
    }

    @PostMapping("/chats/{chat-id}/messages")
    public ResponseEntity<Object> postMessage(@RequestBody MessageDto message,
                                              @PathVariable("chat-id") int chatId,
                                              @RequestHeader("Auth-Token") String token) {
        chatService.saveAndDeliverMessage(token, chatId, message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("chats/{chat-id}/messages")
    public ResponseEntity<List<MessageDto>> getMessages(
            @PathVariable("chat-id") int chatId, @RequestHeader("Auth-Token") String token) {
        return new ResponseEntity<>(chatService.getMessages(token, chatId), HttpStatus.ACCEPTED);
    }
}
