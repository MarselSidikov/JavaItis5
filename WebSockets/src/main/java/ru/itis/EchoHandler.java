package ru.itis;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 26.01.17
 * EchoHandler
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// перехватчик сообщений из определенной сессии сокетов
public class EchoHandler extends TextWebSocketHandler {
    private Map<Integer, WebSocketSession> sessions;

    public EchoHandler() {
        sessions = new HashMap<>();
    }
    /**
     * метод срабатывает после того, как с клиента было подключение
     * @param session - сессия, с которой сейчас подключен сокет-клиент
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("CONNECTED FROM CLIENT " + session.getRemoteAddress());
    }

    /**
     * Перехват текстового сообщения
     * @param session
     * @param textMessage
     * @throws IOException
     */
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        String message = textMessage.getPayload();
        Matcher matcher = Pattern.compile("\\d+").matcher(message);
        matcher.find();
        int userId = Integer.valueOf(matcher.group());
        sessions.putIfAbsent(userId, session);
        for (Map.Entry<Integer, WebSocketSession> entry : sessions.entrySet()) {
            if (entry.getKey() != userId) {
                entry.getValue().sendMessage(new TextMessage(message));
            }
        }
    }
}
