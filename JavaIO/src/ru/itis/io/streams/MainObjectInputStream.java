package ru.itis.io.streams;

import ru.itis.Human;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * Created by Admin on 04.04.2017.
 */
public class MainObjectInputStream {
    public static void main(String[] args) throws Exception {
        ObjectInputStream inputStream =
                new ObjectInputStream(new FileInputStream("human.bin"));

        Human humanFromFile = (Human)inputStream.readObject();

        System.out.println(humanFromFile.getAge() + " " + humanFromFile.getName());
    }
}
