package ru.itis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.itis.dto.MessageDto;

import java.io.IOException;
import java.util.*;

@Service
public class SessionsServiceImpl implements SessionsService {

    // id - чата - ключ
    // значение - список сессий данного чата
    private Map<Integer, List<WebSocketSession>> sessions;

    public SessionsServiceImpl() {
            this.sessions = new HashMap<>();
    }

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void submitSession(int chatId, WebSocketSession session) {
        // если сессий для данного чата еще не было
        if (sessions.get(chatId) == null) {
            // создаем список сессий для данного чата с одной сессией
            ArrayList<WebSocketSession> newChatSessions = new ArrayList<>();
            newChatSessions.add(session);
            sessions.put(chatId, newChatSessions);
        } else {
            // если список сессий уже был, просто добавляем сессию
            List<WebSocketSession> chatSessions = sessions.get(chatId);
            chatSessions.add(session);
        }
    }

    @Override
    public void sendToSessions(MessageDto message, int chatId) {
        List<WebSocketSession> sessions = getSessionsOfChat(chatId);
        // для каждой сессии
        if (sessions != null && sessions.size() != 0) {
            for (WebSocketSession session : sessions) {
                try {
                    // отправляем сообщение
                    if (session.isOpen()) {
                        String json = mapper.writeValueAsString(message);
                        session.sendMessage(new TextMessage(json.getBytes()));
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    private List<WebSocketSession> getSessionsOfChat(int chatId) {
        return sessions.get(chatId);
    }
}
