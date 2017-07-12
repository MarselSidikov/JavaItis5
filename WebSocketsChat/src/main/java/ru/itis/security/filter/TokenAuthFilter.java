package ru.itis.security.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.security.auth.TokenAuthentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 25.01.17
 * TokenAuthFilter
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TokenAuthFilter extends GenericFilterBean {
    private static final String AUTH_TOKEN = "Auth-Token";

    private AuthenticationManager authenticationManager;

    public TokenAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // перехватили запрос
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println(((HttpServletRequest) servletRequest).getRequestURI());
        try {
            String token = extractTokenFromHeaders(httpServletRequest);
            if (token == null) {
                token = extractTokenFromCookies(httpServletRequest);
            }
            // если запрос не требует защиты
            if (isNotRequiringProtection(httpServletRequest)) {
                // filterChain - цепочка фильров
                // даем доступ дальше
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (token == null || token.equals("")) {
                throw new IllegalArgumentException("Token not found");
            } else {
                // выполняет аутентификацию с этим токеном
                authenticationManager.authenticate(new TokenAuthentication(token));
                // если manager не дал ошибки - разрешаем дальше
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (AuthenticationException authenticationException) {
            throw new IllegalArgumentException(authenticationException);
        }
    }

    private boolean isNotRequiringProtection(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/users") && request.getMethod().equals("POST")
                || request.getRequestURI().startsWith("/login") && request.getMethod().equals("POST")
                || request.getRequestURI().equals("/signin.html") && request.getMethod().equals("GET")
                || request.getRequestURI().equals("/registration.html") && request.getMethod().equals("GET")
                || request.getRequestURI().startsWith("/authHandler") && request.getMethod().equals("GET")
                || request.getRequestURI().startsWith("/chat") && request.getMethod().equals("GET")
                || request.getRequestURI().equals("/stomp_chat.html") && request.getMethod().equals("GET")
                || request.getRequestURI().endsWith("favicon.ico");
    }

    private String extractTokenFromHeaders(HttpServletRequest request) {
        return request.getHeader(AUTH_TOKEN);
    }

    private String extractTokenFromCookies(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Auth-Token")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
