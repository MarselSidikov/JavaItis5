package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.dao.*;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AppContext context = new AppContext();
        UsersDao usersDao = context.getComponent(UsersDao.class);
        usersDao.findAll();
        List<User> userList = usersDao.findAll();
        int i = 0;
    }
}
