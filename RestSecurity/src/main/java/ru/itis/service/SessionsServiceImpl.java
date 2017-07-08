package ru.itis.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;

@Service
public class SessionsServiceImpl implements SessionsService {

    private Map<Integer, List<WebSocketSession>> sessions;

    public SessionsServiceImpl() {
            this.sessions = new HashMap<>();
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
    public List<WebSocketSession> getSessionsOfChat(int chatId) {
        return sessions.get(chatId);
    }
}
