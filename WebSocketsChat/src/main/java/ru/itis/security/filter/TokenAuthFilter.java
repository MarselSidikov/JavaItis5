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
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        if (isNotUnprotectedRequest(httpServletRequest)) {
            String token = getTokenFromHttp(httpServletRequest);
            authenticationManager.authenticate(new TokenAuthentication(token));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isNotUnprotectedRequest(HttpServletRequest httpServletRequest) {
        return !(isRequestOnUnprotectedHtmlPage(httpServletRequest)
                || isUnprotectedRestRequest(httpServletRequest)
                || isUnprotectedSourcesRequest(httpServletRequest));
    }

    private boolean isRequestOnUnprotectedHtmlPage(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            String page = request.getRequestURI();
            return page.equals("/signin.html")
                    || page.equals("/registration.html")
                    || page.equals("/stomp_chat.html")
                    || page.equals("/chat_list.html");
        } else return false;
    }

    private boolean isUnprotectedRestRequest(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/users") && request.getMethod().equals("POST")
                || request.getRequestURI().startsWith("/login") && request.getMethod().equals("POST")
                || request.getRequestURI().startsWith("/authHandler") && request.getMethod().equals("GET")
                || request.getRequestURI().startsWith("/chat") && request.getMethod().equals("GET");
    }

    private boolean isUnprotectedSourcesRequest(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/js") && request.getMethod().equals("GET")
                || request.getRequestURI().startsWith("/css") && request.getMethod().equals("GET")
                || request.getRequestURI().endsWith("favicon.ico");
    }
}
