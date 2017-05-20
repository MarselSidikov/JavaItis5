package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.itis.config.app.AppConfig;
import ru.itis.services.AutoService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 20.05.2017
 * AutoServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AutoServlet extends HttpServlet {

    private AutoService autoService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        autoService = (AutoService)config.getServletContext().getAttribute("autoService");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        /*
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.addActiveProfile("dev");
        context.load("ru.itis\\context.xml");
        context.refresh();
        */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("autos", autoService.getAllAuto());
        req.getRequestDispatcher("/jsp/autosAll.jsp").forward(req, resp);
    }
}
