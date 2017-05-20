package ru.itis.config.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dao.UsersDao;
import ru.itis.services.AutoService;
import ru.itis.services.UsersService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 20.05.2017
 * AppListener
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UsersService usersService = context.getBean(UsersService.class);
        AutoService autoService = context.getBean(AutoService.class);
        servletContextEvent.getServletContext().setAttribute("usersService", usersService);
        servletContextEvent.getServletContext().setAttribute("autoService", autoService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
