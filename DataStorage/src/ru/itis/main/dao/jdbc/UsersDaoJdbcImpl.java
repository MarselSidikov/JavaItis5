package ru.itis.main.dao.jdbc;

import ru.itis.main.dao.UsersDao;
import ru.itis.main.models.Auto;
import ru.itis.main.models.AutoBuilder;
import ru.itis.main.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 04.05.2017
 * UsersDaoJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersDaoJdbcImpl implements UsersDao {

    //language=SQL
    private final String SQL_SELECT_USERS_BY_AGE = "SELECT * FROM group_user WHERE age = ?";

    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO group_user(login, password, name, age)" +
            "VALUES (?, ?, ?, ?)";

    //language=SQL
    private final String SQL_UPDATE_USER_BY_ID = "UPDATE  group_user " +
            "SET name = ?, login = ?, password = ?, age = ? WHERE id = ?";

    // language=SQL
    private final String SQL_SELECT_ALL_USERS = "SELECT * from group_user u, auto a WHERE u.id = a.owner_id";
    // language=SQL
    private final String SQL_SELECT_ALL_USERS_WITH_JOIN = "SELECT * FROM group_user " +
            "LEFT JOIN auto ON group_user.id = auto.owner_id";

    private Connection connection;

    public UsersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public User find(int id) {
        return null;
    }

    @Override
    public int save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setInt(4, model.getAge());

            int addedRowsCount = statement.executeUpdate();

            if (addedRowsCount == 0) {
                throw new IllegalStateException("Bad in SQL");
            } else {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS_WITH_JOIN);
            ResultSet resultSet = preparedStatement.executeQuery();

            Map<Integer, User> usersMap = new HashMap<>();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                if (usersMap.get(userId) == null) {
                    User user = new User.Builder()
                            .id(resultSet.getInt(1))
                            .name(resultSet.getString("name"))
                            .login(resultSet.getString("login"))
                            .password(resultSet.getString("password"))
                            .age(resultSet.getInt("age"))
                            .autos(new ArrayList<>()).build();
                    usersMap.put(userId, user);
                }

                Auto auto = new AutoBuilder()
                        .setId(resultSet.getInt(6))
                        .setIdOwner(usersMap.get(userId))
                        .setCarMileage(resultSet.getDouble("carmileage"))
                        .setColor(resultSet.getString("color"))
                        .setModel(resultSet.getString("model"))
                        .setUsed(resultSet.getBoolean("used"))
                        .createAuto();

                usersMap.get(userId).getAutos().add(auto);
            }
            return new ArrayList<>(usersMap.values());
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> findAllByAge(int age) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_BY_AGE);
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> resultUsersList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User.Builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .age(resultSet.getInt("age")).build();
                resultUsersList.add(user);
            }
            return resultUsersList;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> findAllByName(String name) {
        return null;
    }
}
