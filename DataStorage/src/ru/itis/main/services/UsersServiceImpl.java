package ru.itis.main.services;

import ru.itis.main.dao.UsersDao;
import ru.itis.main.models.User;

import java.util.List;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public class UsersServiceImpl implements UsersService{

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void register(User user){
        usersDao.save(user);
    }

    public boolean isRegistered(String userName){
        // вытащили всех пользователей
        List<User> users = usersDao.findAll();
        // смотрим i-го пользователя и проверяем совпадения
        for(int i =0; i < users.size(); i++){
            if(users.get(i).getName().equals(userName)){
                return true;
            }
        }
        return false;
    }
}
