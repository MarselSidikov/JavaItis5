package ru.itis;

public class Main {

    public static void main(String[] args) {
        int a[] = {-4, 10, -2, 1, 1, 1, 34, 56, 9, 11};
        Sorter sorter = new Sorter();
        sorter.sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
