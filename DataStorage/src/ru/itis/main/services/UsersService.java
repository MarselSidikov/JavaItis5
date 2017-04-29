package ru.itis.main.services;

import ru.itis.main.models.User;

/**
 * 29.04.2017
 * UsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    void register(User user);
    boolean isRegistered(String userName);
}
