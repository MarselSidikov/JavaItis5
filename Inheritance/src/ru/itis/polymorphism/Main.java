package ru.itis.polymorphism;

import ru.itis.animals.Animal;
import ru.itis.animals.Cat;
import ru.itis.animals.Koala;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Murka", 1, 2);

        Animal catAsAnimal = cat;

        catAsAnimal.eat(5);
        System.out.println("Cat after eating: " + cat.getWeight());

        Animal koalaAsAnimal = new Koala(2, 3, 10);

        koalaAsAnimal.eat(5);

        System.out.println("Koala after eating: " + koalaAsAnimal.getWeight());


    }
}
