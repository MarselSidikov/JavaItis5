package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.model.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

/**
 * 25.01.17
 * UsersDaoSimpleImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class UsersDaoJdbcImpl implements UsersDao {

    private NamedParameterJdbcTemplate namedParameterTemplate;
    private JdbcTemplate template;

    // language=SQL
    private static final String SQL_FIND_BY_TOKEN =
            "SELECT * FROM itis_user WHERE  token = :token";

    // language=SQL
    private static final String SQL_FIND_BY_LOGIN =
            "SELECT * FROM itis_user WHERE login = :login";

    // language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO itis_user(login, password_hash, age, user_name) " +
                    "VALUES (?, ?, ?, ?)";

    // language=SQL
    private static final String SQL_UPDATE_TOKEN =
            "UPDATE itis_user SET token = :token WHERE id = :id";

    // language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM itis_user";

    // language=SQL
    private static final String SQL_TOKEN_IS_EXIST =
            "SELECT  EXISTS (SELECT 1 from itis_user WHERE  token = :token)";

    private RowMapper<User> rowMapper = (resultSet, i) -> new User(resultSet.getInt("id"),
            resultSet.getString("login"), resultSet.getString("password_hash"), resultSet.getInt("age"),
            resultSet.getString("user_name"), resultSet.getString("token"));


    @Autowired
    public UsersDaoJdbcImpl(DataSource dataSource) {
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public User findByToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return namedParameterTemplate.queryForObject(SQL_FIND_BY_TOKEN, params, rowMapper);
    }

    @Override
    public User findByLogin(String login) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        return namedParameterTemplate.queryForObject(SQL_FIND_BY_LOGIN, params, rowMapper);
    }

    @Override
    public User save(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getName());
            return statement;
        }, holder);

        int id =  (Integer)(holder.getKeyList().get(0).get("id"));

        user.setId(id);

        return user;
    }

    @Override
    public void updateToken(int id, String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("token", token);
        namedParameterTemplate.update(SQL_UPDATE_TOKEN, params);
    }

    @Override
    public List<User> findAll() {
        return namedParameterTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    @Override
    public boolean isExistToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return namedParameterTemplate.queryForObject(SQL_TOKEN_IS_EXIST, params, Boolean.class) == true;
    }
}
