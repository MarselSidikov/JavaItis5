package ru.itis.polymorphism;

import ru.itis.animals.Animal;
import ru.itis.animals.Cat;
import ru.itis.animals.Koala;

public class PolyMain {
    public static void main(String[] args) {
        Cat cat = new Cat("Murka", 10,5);
        Cat cat1 = new Cat("Murka1", 10,5);
        Cat cat2 = new Cat("Murka2", 10,5);

        Koala koala = new Koala(10,10,10);
        Koala koala1 = new Koala(10,10,10);
        Koala koala2 = new Koala(10,10,10);

        /*
        Animal animals[] = new Animal[6];
        animals[0] = cat;
        animals[1] = koala;
        animals[2] = cat1;
        animals[3] = koala1;
        animals[4] = koala2;
        animals[5] = cat2;
        */

        Animal animals[] = {cat, koala, cat1, koala2, koala1, cat2};

        for (int i = 0; i < animals.length; i++) {
            animals[i].go();
        }
    }
}
