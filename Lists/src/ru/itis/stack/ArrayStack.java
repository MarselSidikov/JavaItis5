package ru.itis.stack;


/**
 * 14.03.2017
 * ArrayStack
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayStack {
    private final int MAX_STACK_SIZE = 10;

    private int count;
    private char elements[];

    public ArrayStack() {
        elements = new char[MAX_STACK_SIZE];
        count = 0;
    }

    public void push(char element) {
        elements[count] = element;
        count++;
    }

    public char pop() {
        count--;
        return elements[count];
    }

    public char peek() {
        return elements[count - 1];
    }
}
