package ru.itis.list;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addToTail(1);
        linkedList.addToTail(2);
        linkedList.addToTail(3);
        linkedList.addToTail(4);
        linkedList.addToTail(5);

        linkedList.remove(5);
        linkedList.show();
    }
}
