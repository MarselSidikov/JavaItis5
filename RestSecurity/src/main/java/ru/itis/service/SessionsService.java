package ru.itis.service;

import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface SessionsService {
    /**
     * Привязываем сессию к чату
     * @param chatId
     * @param session
     */
    void submitSession(int chatId, WebSocketSession session);

    List<WebSocketSession> getSessionsOfChat(int chatId);
}
