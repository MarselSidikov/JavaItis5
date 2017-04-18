package ru.itis.main;

import com.sun.xml.internal.bind.v2.model.core.ID;
import ru.itis.main.generators.IdGenerator;
import ru.itis.main.generators.SingletonIdGenerator;
import ru.itis.main.models.User;
import ru.itis.main.storages.UsersDataStorage;

import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        UsersDataStorage usersDataStorage = new UsersDataStorage("users.txt");
        UsersDataStorage usersDataStorage1 = new UsersDataStorage("users.txt");
        User user = new User("marsel", "qwerty007", "Marsel", 23);
        usersDataStorage.save(user);
        usersDataStorage1.save(user);
        // TODO создать две DataStorage с разными idGenerator и протестируйте
    }
}
