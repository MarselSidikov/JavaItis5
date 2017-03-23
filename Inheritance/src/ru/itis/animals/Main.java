package ru.itis.animals;

public class Main {

    public static void main(String[] args) {
        // Animal animal = new Animal(10, 10);
        Cat cat = new Cat("Murka", 3, 20);

        cat.eat(1);

        System.out.println("Cat weight after 1 food eating: " + cat.getWeight());

        Koala koala = new Koala(5, 10, 4);

        koala.eat(3);
        koala.sleep(10);

        System.out.println("Koala after sleep: " + koala.getSleepingHours());
        System.out.println("Koala after eat: " + koala.getWeight());
    }
}
