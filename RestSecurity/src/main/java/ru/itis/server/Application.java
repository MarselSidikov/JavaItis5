package ru.itis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 25.01.17
 * Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.itis.config")
public class Application  {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/itis_users");
        driverManagerDataSource.setPassword("qwerty007");
        driverManagerDataSource.setUsername("postgres");
        return driverManagerDataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
