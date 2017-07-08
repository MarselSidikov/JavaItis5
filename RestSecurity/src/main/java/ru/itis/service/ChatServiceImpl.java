package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.itis.dao.ChatsDao;
import ru.itis.dao.MessagesDao;
import ru.itis.dao.UsersDao;
import ru.itis.dto.MessageDto;
import ru.itis.model.Chat;
import ru.itis.model.Message;
import ru.itis.model.User;

import java.io.IOException;
import java.util.*;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private MessagesDao messagesDao;

    @Autowired
    private ChatsDao chatsDao;

    @Autowired
    private SessionsService sessionsService;

    @Override
    public List<MessageDto> getMessages(String token, int chatId) {
        return null;
    }

    @Override
    public void saveAndDeliverMessage(String token, int chatId, MessageDto message) {
        if (isUserInChat(token, chatId)) {
            User user = usersDao.findByToken(token);
            Chat chat = chatsDao.findOne(chatId);
            Message model = new Message();
            model.setAuthor(user);
            model.setChat(chat);
            model.setText(message.getMessage());
            messagesDao.save(model);

            List<WebSocketSession> sessions = sessionsService.getSessionsOfChat(chatId);
            for (WebSocketSession session : sessions) {
                try {
                    session.sendMessage(new TextMessage(message.getMessage().getBytes()));
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

    }

    @Override
    public boolean isUserInChat(String token, int chatId) {
        User user = usersDao.findByToken(token);
        return chatsDao.isUserInChat(user.getId(), chatId);
    }
}
