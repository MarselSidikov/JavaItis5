package ru.itis.security.utils;

import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class TokenUtils {
    private static final String AUTH_TOKEN = "Auth-Token";

    public static String getTokenFromHttp(HttpServletRequest request) {
        String token = extractTokenFromHttpHeaders(request);
        if (token == null) {
            token = extractTokenFromHttpCookies(request);
        }
        verifyToken(token);
        return token;
    }

    public static String getTokenFromStompWebSockets(StompHeaderAccessor accessor) {
        String token = accessor.getFirstNativeHeader(AUTH_TOKEN);
        verifyToken(token);
        return token;
    }

    public static String getTokenFromWebSocketsMessage(TextMessage textMessage) {
        String message[] = textMessage.getPayload().split(" ");
        String token = message[0];
        verifyToken(token);
        return token;
    }

    private static String extractTokenFromHttpHeaders(HttpServletRequest request) {
        String token = request.getHeader(AUTH_TOKEN);
        verifyToken(token);
        return token;
    }

    private static String extractTokenFromHttpCookies(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Auth-Token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        verifyToken(token);
        return token;
    }

    private static void verifyToken(String token) {
        if (token == null || token.equals("")) {
            throw new IllegalArgumentException("Token Not found");
        }
    }
}
