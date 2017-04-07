package ru.itis.models;

public class Tiger extends AbstractAnimal implements Predator {

    public Tiger(String name) {
        super(name);
    }

    @Override
    public void am() {
        System.out.println("I'll kill you!");
    }
}
