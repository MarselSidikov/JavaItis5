package ru.itis;

import ru.itis.models.*;
import ru.itis.zoo.Zoo;
import ru.itis.zoo.ZooForChildren;
import ru.itis.zoo.ZooNotForChildrenHaha;

public class MainCast {

    /**
     * Метод находит живтоное animal в зоопарке, и его трогает
     * @param zooForChildren зоопарк, в котором необходимо найти животное
     */
    public static void touchInZoo(String name, ZooForChildren<? extends Herbivore> zooForChildren) {
        Herbivore herbivore = zooForChildren.get(name);
        herbivore.mimi();
    }

    public static void addHerbivoreInZoo(GoodBear bear, ZooForChildren<? super GoodBear> zooBears) {
        zooBears.add(bear);
    }

    public static void main(String[] args) {
        ZooForChildren<Koala> koalasZoo = new ZooForChildren<>();

        Koala koala1 = new Koala("Mimishka");
        Koala koala2 = new Koala("Veselchak");
        Koala koala3 = new Koala("Bad koala");

        koalasZoo.add(koala1);
        koalasZoo.add(koala2);
        koalasZoo.add(koala3);

        ZooForChildren<Panda> pandasZoo = new ZooForChildren<>();

        Panda panda1 = new Panda("Sonya");
        Panda panda2 = new Panda("Chack Norris");
        Panda panda3 = new Panda("Linus Torvalds");

        pandasZoo.add(panda1);
        pandasZoo.add(panda2);
        pandasZoo.add(panda3);

        /*
        ZooNotForChildrenHaha zooNotForChildrenHaha = new ZooNotForChildrenHaha();

        touchInZoo(koala1, zooNotForChildrenHaha);
        */
        touchInZoo("Milkey", pandasZoo);
    }

    public static void test() {

        ZooForChildren<Panda> pandasZoo = new ZooForChildren<>();
        ZooForChildren zooForChildren = pandasZoo;
        // ZooForChildren<Herbivore> zooForChildren1 = pandasZoo;
        ZooForChildren<? extends Herbivore> zooForChildren2 = pandasZoo;

    }
}
