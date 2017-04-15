package ru.itis.main.storages;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

public class UsersDataStorage {

    // поле, в котором хранится имя файла
    // в котором содежатся данные о пользователях
    private String fileName;
    private IdGenerator idGenerator;

    public UsersDataStorage(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    public int save(User user) {
        try {
            // на вход принимаем можель без id
            // генерируем id
            user.setId(idGenerator.generateId());
            // открываем файловый поток для дозаписи
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            // преобразуем пользователя в строку через toString
            String userDataAsString = user.toString();
            // преобразуем строку в массив байтов
            // записываем в файл
            writer.write(userDataAsString);
            writer.newLine();
            writer.close();
            return user.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
    }

    public User find(int id) {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            String currentUserData = reader.readLine();

            while (currentUserData != null) {
                String currentUserDataAsArray[] =
                        currentUserData.split(" ");

                int currentUserId =
                        Integer.parseInt(currentUserDataAsArray[0]);

                if (currentUserId == id) {
                    User founded = new User(
                            currentUserDataAsArray[1],
                            currentUserDataAsArray[2],
                            currentUserDataAsArray[3],
                            Integer.parseInt(currentUserDataAsArray[4]));
                    founded.setId(id);
                    reader.close();
                    return founded;
                }
                currentUserData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    public List<User> findAll() {
        ArrayList<User> allUsers = new ArrayList<>();
        // TODO: реализовать чтение всех пользователей из файла
        // и добавление их в список
        return null;
    }
}
