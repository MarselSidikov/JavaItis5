package ru.itis.nodes;

public class Main {

    public static void main(String[] args) {
	    Node a = new Node(10);
	    Node b = new Node(11);
	    Node c = new Node(12);
	    Node d = new Node(13);

	    a.setNext(b);
	    b.setNext(c);
	    c.setNext(d);

	    Node current = a;

	    while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

        Node e = new Node(15);
	    b.setNext(e);
	    e.setNext(c);

	    current = a;
		System.out.println("After insert");
		while (current != null) {
			System.out.println(current.getValue());
			current = current.getNext();
		}

    }
}
