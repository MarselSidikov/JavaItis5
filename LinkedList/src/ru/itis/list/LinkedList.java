package ru.itis.list;

import ru.itis.nodes.Node;

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

    public void addToTail(int value) {
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

    public void remove(int value) {
        Node current = head;

        while (current.getNext() != null) {
            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}
