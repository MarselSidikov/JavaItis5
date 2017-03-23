package ru.itis.animals;

public abstract class Animal {
    protected int weight;
    protected int height;

    public Animal(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public void eat(int foodAmount) {
        this.weight = this.weight + foodAmount;
    }

    public abstract void go();
}
