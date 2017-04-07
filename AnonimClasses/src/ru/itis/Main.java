package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Summator summator = new Summator() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        System.out.println(summator.sum(6, 7));

        Summator badSummator = (a, b) -> a * b;

        System.out.println(badSummator.sum(12, 3));
    }
}
