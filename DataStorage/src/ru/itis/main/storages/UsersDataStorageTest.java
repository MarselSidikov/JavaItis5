package ru.itis.main.storages;

import org.junit.Before;
import org.junit.Test;
import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.User;

import static org.junit.Assert.*;

/**
 * 18.04.2017
 * UsersDataStorageTest
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersDataStorageTest {

    // объектная переменная для тестируемого класса
    private UsersDataStorage usersDataStorage;

    @Before // Before - говорит JUnit-у о том, что этот метод
    // нужно вызывать перед каждым тестом
    public void setUp() throws Exception {
        this.usersDataStorage = new UsersDataStorage("test\\users.txt",
                new IdGenerator("test\\id.txt"));
    }

    @Test // Test - говорит JUnit-у, что данный метод является методом-тестом
    public void testFind() throws Exception {
        User expected = new User(3, "ayazTheBest", "qwerty008", "Ayaz", 25);
        User actual = usersDataStorage.find(3);

        assertEquals(expected, actual);
    }

}