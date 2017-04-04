package ru.itis.io.filter.streams;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream("hello.txt"));
    }
}
