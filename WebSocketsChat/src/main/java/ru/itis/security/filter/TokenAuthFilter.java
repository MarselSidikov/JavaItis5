package ru.itis.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.security.auth.TokenAuthentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ru.itis.security.utils.TokenUtils.getTokenFromHttp;

/**
 * 25.01.17
 * TokenAuthFilter
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TokenAuthFilter extends GenericFilterBean {

    @Autowired
    private AuthenticationManager authenticationManager;

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // преобразование из ServletRequest в HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        // запрос требует проверки безопасности
        if (!isUnprotectedRestRequest(httpServletRequest)) {
            // достаем токен из запроса
            String token = getTokenFromHttp(httpServletRequest);
            // выполняем аутентификацию
            authenticationManager.authenticate(new TokenAuthentication(token));
        }
        // идем дальше
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isUnprotectedRestRequest(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/users") && request.getMethod().equals("POST")
                || request.getRequestURI().startsWith("/login") && request.getMethod().equals("POST")
                || request.getRequestURI().startsWith("/authHandler") && request.getMethod().equals("GET")
                || request.getRequestURI().startsWith("/chat") && request.getMethod().equals("GET")
                || request.getRequestURI().startsWith("/files") && request.getMethod().equals("POST");
    }

}
