package ru.itis.list;

public class Main {

    static int count;

    public static void addToEnd(int array[], int element) {
        array[count] = element;
        count++;
    }

    public static void main(String[] args) {
	    int elements[] = new int[10];

        elements[0] = 5;
        count++;
        elements[1] = 6;
        count++;

        addToEnd(elements, 7);
        addToEnd(elements, 11);
        addToEnd(elements, 12);

        for (int i = 0; i < count; i++) {
            System.out.println(elements[i]);
        }
    }
}
