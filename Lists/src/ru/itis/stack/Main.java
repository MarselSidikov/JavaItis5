package ru.itis.stack;

/**
 * 14.03.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push('a');
        stack.push('b');
        stack.push('c');

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
