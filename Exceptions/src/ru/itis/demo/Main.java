package ru.itis.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

    public static void showEvenNumber(int number) {
        if (number % 2 == 0) {
            System.out.println(number);
        } else {
            throw new IllegalArgumentException("Not even");
        }
    }

    public static void getFile(String fileName) throws FileNotFoundException {
        if (fileName == null || fileName == "") {
            throw new FileNotFoundException("Empty string");
        } else {
            System.out.println("all okey");
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        showEvenNumber(9);

        try {
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream("Hello.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        try {
            getFile("hello.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Bad");
        }

        getFile("");
    }
}
