package ru.itis.service;

import org.springframework.web.socket.WebSocketSession;
import ru.itis.dto.MessageDto;

import java.util.List;


public interface ChatService {
    /**
     * Получить все сообщения в чате
     * @param chatId
     * @return список сообщений
     */
    List<MessageDto> getMessages(String token, int chatId);


    void saveAndDeliverMessage(String token, int chatId, MessageDto message);

    boolean isUserInChat(String token, int chatId);
}
