package ru.itis.main.storages;

import ru.itis.main.storages.UsersDataStorage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 18.04.2017
 * DataStorageFactory
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DataStorageFactory {
    public static UsersDataStorage getUsersDataStorage() {
        // TODO: метод, возвращающий созданный DataStorage, которому проставлен
        //файл из app.properties
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("resources\\app.properties"));
            String fileName = properties.getProperty("users.file");
            return new UsersDataStorage(fileName);
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    //TODO -метод возвращающий DAO с  Auto
}
