package ru.itis.demo;

public class MainStackOverflowAndOutOfMemory {
    public static void fact(int n) {
        fact(n);
    }

    public static void fact() {
        Object object[] = new Object[Integer.MAX_VALUE];
    }

    public static void main(String[] args) {
        // fact(1000000);
        try {
            fact();
        } catch (OutOfMemoryError e) {
            System.out.println("Oops");
        }
    }
}
