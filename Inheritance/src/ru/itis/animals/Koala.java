package ru.itis.animals;

public class Koala extends Animal {
    private int sleepingHours;

    public Koala(int weight, int height, int sleepingHours) {
        super(weight, height);
        this.sleepingHours = sleepingHours;
    }

    public void sleep(int hours) {
        this.sleepingHours = this.sleepingHours + hours;
    }

    public int getSleepingHours() {
        return sleepingHours;
    }

    @Override
    public void eat(int foodAmount) {
        super.weight = super.weight + foodAmount * 2;
    }

    public void go() {
        System.out.println("I'm Koala, and go!");
    }
}
