package ru.itis;

/**
 * 20.04.2017
 * LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList<T> implements List<T> {

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node last;

    private int count;

    public LinkedList() {
        this.count = 0;
        this.head = null;
        this.last = null;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            /*
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            */
            this.last.next = newNode;
            this.last = newNode;
        }
    }

    @Override
    public void delete(T element) {

    }

    @Override
    public void removeByIndex(int index) {

    }

    @Override
    public T get(int index) {
        if (index < count && index > 0) {
            Node current = this.head;
            int i = 0;

            while (i < index) {
                current = current.next;
                i++;
            }

            return current.value;
        } throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public void addToBegin(T element) {

    }




}
