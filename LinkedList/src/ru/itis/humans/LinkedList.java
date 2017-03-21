package ru.itis.humans;

public class LinkedList {
    private Node head;
    private Node tail;

    private int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    /*
    public void addToTail(int value) {
        // создали узел для нового значения
        Node newNode = new Node(value);

        // если в списке еще нет элементов
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }

        count++;
    }
    */

    public void addToTail(Human value) {
        // создали узел для нового значения
        Node newNode = new Node(value);

        // если в списке еще нет элементов
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }

        count++;
    }

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public void addList(LinkedList otherList) {
        this.tail.setNext(otherList.head);
        this.tail = otherList.tail;
    }
}
