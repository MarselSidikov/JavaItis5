package ru.itis.io.streams;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class MainByteArrayOutputStream {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream(20);

        byte bytes[] = "Hello".getBytes();

        outputStream.write(bytes);

        System.out.println(outputStream.toString());
    }
}
