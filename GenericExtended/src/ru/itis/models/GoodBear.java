package ru.itis.models;

public class GoodBear extends Panda {

    public GoodBear(String name) {
        super(name);
    }

    @Override
    public void mimi() {
        System.out.println("Bear mimi!");
    }
}
