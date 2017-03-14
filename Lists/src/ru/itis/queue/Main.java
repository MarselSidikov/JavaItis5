package ru.itis.queue;

/**
 * 14.03.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
