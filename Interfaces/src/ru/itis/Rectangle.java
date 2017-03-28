package ru.itis;

public class Rectangle implements Figure {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public double calcPerimeter() {
        return a * 2 + b * 2;
    }

    @Override
    public double calcArea() {
        return a * b;
    }
}
