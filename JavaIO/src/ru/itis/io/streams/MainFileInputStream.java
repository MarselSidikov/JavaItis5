package ru.itis.io.streams;


import java.io.FileInputStream;
import java.io.InputStream;

public class MainFileInputStream {
    public static void main(String[] args) throws Exception {
        InputStream inputStream =
                new FileInputStream("hello.txt");

        int byteFromFile = inputStream.read();
        System.out.println((char)byteFromFile);

        byte bytes[] = new byte[10];

        int countOfReadBytes = inputStream.read(bytes);

        System.out.write(bytes);
        // System.out.println(bytes);

    }
}
