package ru.itis.models;

public class Koala extends AbstractAnimal implements Herbivore {

    public Koala(String name) {
        super(name);
    }

    @Override
    public void mimi() {
        System.out.println("Koala mimi!");
    }
}
