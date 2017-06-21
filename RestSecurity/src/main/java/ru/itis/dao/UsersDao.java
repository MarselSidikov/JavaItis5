package ru.itis.dao;

import ru.itis.model.User;

import java.util.List;

/**
 * 25.01.17
 * UsersDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersDao {
    User findByToken(String token);
    User findByLogin(String login);
    User save(User user);
    void updateToken(int id, String token);
    List<User> findAll();

    boolean isExistToken(String token);
}
