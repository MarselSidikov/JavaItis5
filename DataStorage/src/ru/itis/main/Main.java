package ru.itis.main;

import ru.itis.main.storages.DataStorageFactory;
import ru.itis.main.storages.UsersDataStorage;

public class Main {

    public static void main(String[] args) {
        UsersDataStorage storage = DataStorageFactory.getUsersDataStorage();

    }
}
