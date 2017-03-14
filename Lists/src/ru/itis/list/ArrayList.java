package ru.itis.list;

/**
 * 14.03.2017
 * ArrayList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayList {
    private final int MAX_ARRAY_SIZE = 10;

    private int count;
    private int elements[];

    public ArrayList() {
        count = 0;
        elements = new int[MAX_ARRAY_SIZE];
    }

    public void addToEnd(int element) {
        addByIndex(element, count);
    }

    public void addToBegin(int element) {
        addByIndex(element, 0);
    }

    public void addByIndex(int element, int index) {
        if (count < MAX_ARRAY_SIZE) {
            for (int i = count; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            count++;
        } else {
            System.out.println("ArrayList is full");
        }
    }

    public void show() {
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            int temp = elements[i];
            elements[i] = elements[count - 1 - i];
            elements[count - 1 - i] = temp;
        }
    }

    public int getCount() {
        return count;
    }
}
