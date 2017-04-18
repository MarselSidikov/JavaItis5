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
        // TODO: создать Exception UserNotFoundException наследованный от Runtime
        // TODO: выбросить UserNotFound
        return null;
    }

    public List<User> findAll() {
        // TODO: реализовать чтение всех пользователей из файла
        try {
            ArrayList<User> addUsers = new ArrayList<>();
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String currentUserData = reader.readLine();

            while (currentUserData != null) {
                String currentUserDataAsArray[] =
                        currentUserData.split(" ");

                int currentUserId =
                        Integer.parseInt(currentUserDataAsArray[0]);
                User founded = new User(
                        currentUserDataAsArray[1],
                        currentUserDataAsArray[2],
                        currentUserDataAsArray[3],
                        Integer.parseInt(currentUserDataAsArray[4]));
                founded.setId(currentUserId);
                addUsers.add(founded);
                currentUserData = reader.readLine();
            }
            return addUsers;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    public void delete(int id) {
        // получили всех пользователей
        List<User> buffer = findAll();
        // индекс удаляемого пользователя в списке
        int indexOfDeleted = -1;
        // идем по всему списку
        for (int i = 0; i < buffer.size(); i++) {
            // получаем текущего i-го пользователя
            User currentUser = buffer.get(i);
            // если id просматриваемого пользователя
            // совпал с id пользователя, которого мы хотим удалить
            if (currentUser.getId() == id) {
                // запоминаем его индекс
                indexOfDeleted = i;
                // останавливаем цикл
                break;
            }
        }
        // если мы нашли пользователя, которого надо удалить
        if (indexOfDeleted > -1) {
            // удаляем
            buffer.remove(indexOfDeleted);
        }

        flushFromBuffer(buffer);
    }

    /**
     * Обновление записи в хранилище
     * @param user новые данные пользователя. id - там уже указан
     */
    public void update(User user) {
    }

    private void flushFromBuffer(List<User> buffer) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileName));

            for (int i = 0; i < buffer.size(); i++) {
                writer.write(buffer.get(i).toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
