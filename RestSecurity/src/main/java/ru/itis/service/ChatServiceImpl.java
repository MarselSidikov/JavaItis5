package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.itis.dao.UsersDao;
import ru.itis.dto.MessageDto;

import java.io.IOException;
import java.util.*;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private SessionsService sessionsService;

    @Override
    public List<MessageDto> getMessages(String token, int chatId) {
        return null;
    }

    @Override
    public void saveAndDeliverMessage(String token, int chatId, MessageDto message) {
        List<WebSocketSession> sessions = sessionsService.getSessionsOfChat(chatId);
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message.getMessage().getBytes()));
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public boolean isUserInChat(String token, int chatId) {
        return false;
    }
}
