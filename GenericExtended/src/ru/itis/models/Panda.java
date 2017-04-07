package ru.itis.models;

public class Panda extends AbstractAnimal implements Herbivore {

    public Panda(String name) {
        super(name);
    }

    @Override
    public void mimi() {
        System.out.println("Panda mimi!");
    }
}
