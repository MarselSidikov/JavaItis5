package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.dao.UsersDaoJdbcImpl;
import ru.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 11.05.2017
 * UsersServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServlet extends HttpServlet {

    private UsersDaoJdbcImpl usersDao;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");
        usersDao = context.getBean(UsersDaoJdbcImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        PrintWriter writer = response.getWriter();
        writer.print("<table>");
        List<User> users = usersDao.findUsersByAge(24);
        for (int i = 0; i < users.size(); i++) {
            writer.print("<tr>");
            writer.print("<td>" + users.get(i).getId() + "</td>");
            writer.print("<td>" + users.get(i).getName() + "</td>");
            writer.print("<td>" + users.get(i).getAge() + "</td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
         */
        // в запрос кладу атрибут users, который из себя представляет список людей
        request.setAttribute("users", usersDao.findUsersByAge(24));
        // я пераправляю запрос на jsp-страницу
        request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
    }
}
