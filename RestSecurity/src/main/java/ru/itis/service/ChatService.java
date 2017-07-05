package ru.itis.service;

import org.springframework.web.socket.WebSocketSession;
import ru.itis.dto.MessageDto;

import java.util.List;

public interface ChatService {
    /**
     * Проверяет существование пользователя и принадлежность пользователя
     * чату
     * @param token
     */
    boolean userIsExists(String token, int chatId);

    /**
     * Привязываем сессию к чату
     * @param chatId
     * @param session
     */
    void submitSession(int chatId, WebSocketSession session);

    /**
     * Отправка сообщений во все сессии данного чата
     * @param chatId
     * @return
     */
    void sendMessageToChat(int chatId, MessageDto message);
}
