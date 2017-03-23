package ru.itis.animals;

public class Cat extends Animal {
    private String name;

    public Cat(String name, int weight, int height) {
        //вызов конструктора предка
        super(weight, height);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void eat(int foodAmount) {
        this.weight = this.weight + foodAmount/2;
    }

    public void go() {
        System.out.println("I'm cat, and go!");
    }
}
