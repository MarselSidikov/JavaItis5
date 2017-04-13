package ru.itis.main;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.User;
import ru.itis.main.storages.UsersDataStorage;

public class Main {

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator("id.txt");
        UsersDataStorage usersDataStorage = new UsersDataStorage("users.txt", idGenerator);
        User ayaz = new User("ayazTheBest",
                "qwerty008", "Ayaz", 25);
        int id = usersDataStorage.save(ayaz);
        System.out.println(id);
        System.out.println(usersDataStorage.find(6));
    }
}
