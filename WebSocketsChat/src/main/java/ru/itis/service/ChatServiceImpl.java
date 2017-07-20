package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.itis.dao.ChatsDao;
import ru.itis.dao.MessagesDao;
import ru.itis.dao.UsersDao;
import ru.itis.dto.ChatDto;
import ru.itis.dto.MessageDto;
import ru.itis.model.Chat;
import ru.itis.model.Message;
import ru.itis.model.User;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public List<MessageDto> getMessages(String token, int chatId) {
        User user = usersDao.findByToken(token);
        Chat chat = chatsDao.findOne(chatId);
        List<Message> messages = messagesDao.findByAuthorAndChat(user, chat);
        List<MessageDto> result = messages.
                stream().map(message ->
                new MessageDto(0, "Marsel", message.getText())).collect(Collectors.toList());
        return result;
    }

    @Override
    public void saveAndDeliverMessage(String token, int chatId, MessageDto message) {
        // проверяем, что пользователь, отправивший данное сообщение в чат
        // действительно имеет на это право
        if (isUserInChat(token, chatId)) {
            // находим пользователя по токену
            User user = usersDao.findByToken(token);
            // находим чат по его id
            Chat chat = chatsDao.findOne(chatId);
            // созлаем модель сообшения для сохранения
            Message model = new Message();
            // проставляем автора
            model.setAuthor(user);
            // проставляем чат
            model.setChat(chat);
            // проставляем текст
            model.setText(message.getMessage());
            // сохраняем сообщение
            messagesDao.save(model);
            message.setFrom(user.getName());
            messagingTemplate.convertAndSend("/topic/chats/" + chatId, message);
            sessionsService.sendToSessions(message, chatId);
        }
    }

    @Override
    public boolean isUserInChat(String token, int chatId) {
        User user = usersDao.findByToken(token);
        return chatsDao.isUserInChat(user.getId(), chatId);
    }

    @Override
    public void addChat(ChatDto chat, String token) {
        User user = usersDao.findByToken(token);
        Chat model = new Chat(user, null, chat.getName(), null);
        chatsDao.save(model);
    }

    @Override
    public List<ChatDto> getChats() {
        List<Chat> chats = chatsDao.findAll();
        return chats.
                stream().map(chat ->
                new ChatDto(chat.getId(), chat.getName(), chat.getCreator().getName())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void enterChat(String token, int chatId) {
        // нашли чат
        Chat chat = chatsDao.findOne(chatId);
        // нашли пользователя, который хочет добавиться в чат
        User user = usersDao.findByToken(token);
        // получили/не получили пользователя с этим id в чате
        Optional<User> foundUser = chat.getUsers()
                .stream()
                .filter(chatUser -> chatUser.getId() == user.getId())
                .findFirst();
        if (!foundUser.isPresent()) {
            user.getChats().add(chat);
            usersDao.save(user);
        }
    }
}
