package ru.itis.humans;

public class Node {
    private Human value;
    private Node next;

    public Node(Human value) {
        this.value = value;
    }

    public Human getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
