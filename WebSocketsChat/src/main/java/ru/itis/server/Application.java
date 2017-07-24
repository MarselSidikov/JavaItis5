package ru.itis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.itis.model.Chat;
import ru.itis.model.File;
import ru.itis.model.Message;
import ru.itis.model.User;

/**
 * 25.01.17
 * Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@ComponentScan("ru.itis")
@EnableJpaRepositories(basePackages = "ru.itis.repository")
@EntityScan(basePackageClasses = {User.class,
        File.class,
        Message.class,
        Chat.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        ApplicationContext applicationContext = springApplication.run(Application.class,args);
    }

}
