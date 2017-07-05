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

    private Map<Integer, List<WebSocketSession>> sessions;

    @Autowired
    private UsersDao usersDao;

    public ChatServiceImpl() {
        sessions = new HashMap<>();
    }
    @Override
    public boolean userIsExists(String token, int chatId) {
      return usersDao.findByToken(token) != null;
    }

    @Override
    public void submitSession(int chatId, WebSocketSession session) {
        // если сессий для данного чата еще не было
        if (sessions.get(chatId) == null) {
            // создаем список сессий для данного чата с одной сессией
            sessions.put(chatId, Arrays.asList(session));
        } else {
            // если список сессий уже был, просто добавляем сессию
            List<WebSocketSession> chatSessions = sessions.get(chatId);
            chatSessions.add(session);
        }
    }

    @Override
    public void sendMessageToChat(int chatId, MessageDto message) {
        for (WebSocketSession session : sessions.get(chatId)) {
            try {
                session.sendMessage(new TextMessage(message.getMessage().getBytes()));
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
