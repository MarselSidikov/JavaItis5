package ru.itis;

import ru.itis.models.Human;
import ru.itis.models.Koala;
import ru.itis.models.Tiger;
import ru.itis.zoo.Zoo;
import ru.itis.zoo.ZooForChildren;

public class Main {



    public static void main(String[] args) {
        ZooForChildren<Koala> zooForChildren = new ZooForChildren<>();

        Koala koala = new Koala("Mimishka");
        Koala koala2 = new Koala("Veselchak");
        Koala koala3 = new Koala("Bad koala");

        zooForChildren.add(koala);
        zooForChildren.add(koala2);

        zooForChildren.touch(koala2);
        zooForChildren.touch(koala3);
    }
}
