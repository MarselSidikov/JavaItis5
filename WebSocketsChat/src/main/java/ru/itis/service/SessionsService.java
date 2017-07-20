package ru.itis.service;

import org.springframework.web.socket.WebSocketSession;
import ru.itis.dto.MessageDto;

import java.util.List;

public interface SessionsService {
    /**
     * Привязываем сессию пользователя к чату
     * @param chatId
     * @param session
     */
    void submitSession(int chatId, WebSocketSession session);

    void sendToSessions(MessageDto message, int chatId);
}
