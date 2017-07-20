package ru.itis.security.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import ru.itis.security.auth.TokenAuthentication;

import static ru.itis.security.utils.TokenUtils.getTokenFromStompWebSockets;

@Component
public class AuthInterceptor extends ChannelInterceptorAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor =
                MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String authToken = getTokenFromStompWebSockets(accessor);
            authenticationManager.authenticate(new TokenAuthentication(authToken));
        }
        return message;
    }
}
