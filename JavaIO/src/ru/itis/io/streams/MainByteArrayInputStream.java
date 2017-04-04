package ru.itis.io.streams;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainByteArrayInputStream {
    public static void main(String[] args) throws Exception {
        byte bytes[] = new byte[40];
        bytes[0] = 'H';
        bytes[1] = 'e';

        InputStream inputStream = new ByteArrayInputStream(bytes);
        int byteFromStream = inputStream.read();
        System.out.println(byteFromStream);
    }
}
