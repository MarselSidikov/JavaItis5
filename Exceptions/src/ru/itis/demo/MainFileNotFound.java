package ru.itis.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainFileNotFound {
    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new
                InputStreamReader(
                        new FileInputStream(
                                new File("Hello.txt")));
    }
}
