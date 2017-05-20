package ru.itis.config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itis.dao.impl.UsersDaoJdbcImpl;

import javax.sql.DataSource;

/**
 * 20.05.2017
 * TestAutoConfig
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Configuration
public class TestAppConfig {

    @Bean
    public UsersDaoJdbcImpl usersDao() {
        return new UsersDaoJdbcImpl(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new
                EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("ru.itis.test.sql\\group_user_schema.sql")
                .addScript("ru.itis.test.sql\\group_user_data.sql")
                .build();
    }
}
