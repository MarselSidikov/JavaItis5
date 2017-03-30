package ru.itis.demo;

import java.util.Scanner;

public class MainArithmeticError {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            try {
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println("Введи адекватные числа, придурок, потому что: " + e.getMessage());
            }
        }

    }
}
