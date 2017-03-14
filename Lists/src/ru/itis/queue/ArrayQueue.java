package ru.itis.queue;

/**
 * 14.03.2017
 * ArrayQueue
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayQueue {
    private final int MAX_STACK_SIZE = 10;

    private int count;
    private char elements[];

    public ArrayQueue() {
        elements = new char[MAX_STACK_SIZE];
        count = 0;
    }

    // аналогично с ArrayList.addByIndex(element, 0)
    public void enqueue(char element) {
        for (int i = count; i > 0; i--) {
            elements[i] = elements[i - 1];
        }

        elements[0] = element;
        count++;
    }

    public char dequeue() {
        count--;
        return elements[count];
    }
}
