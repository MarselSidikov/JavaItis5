package ru.itis.io.streams;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainFileOutputStream {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream =
                new FileOutputStream("hello.txt", true);

        String message = "Hello, Java! \n";

        byte bytes[] = message.getBytes();
        outputStream.write(bytes);
    }
}
