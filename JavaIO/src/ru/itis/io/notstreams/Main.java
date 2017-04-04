package ru.itis.io.notstreams;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new InputStreamReader(new FileInputStream("hello.txt"));
        char letters[] = new char[20];
        reader.read(letters);
    }
}
