package ru.itis.io.streams;


import ru.itis.Human;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainObjectOutputStream {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream("human.bin"));

        Human human = new Human(23, "Marsel");

        outputStream.writeObject(human);
    }
}
