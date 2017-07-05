package ru.itis.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.service.ChatService;

import java.io.IOException;

/**
 * 26.01.17
 * EchoHandler
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// перехватчик сообщений из определенной сессии сокетов
public class EchoHandler extends TextWebSocketHandler {

    @Autowired
    private ChatService sessionsService;

    /**
     * Перехват текстового сообщения
     * @param session
     * @param textMessage
     * @throws IOException
     */
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        System.out.println(textMessage.getPayload());
        String message[] = textMessage.getPayload().split(" ");
        String token = message[0];
        // TODO: работа с id чата
        int chatId = 1; //Integer.parseInt(message[1]);
        if (!sessionsService.userIsExists(token, chatId)) {
            session.close();
        } else {
            sessionsService.submitSession(chatId, session);
        }
    }
}
