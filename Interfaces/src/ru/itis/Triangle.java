package ru.itis;

public class Triangle implements Figure, FigurePresentable {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcPerimeter() {
        return a + b + c;
    }

    @Override
    public double calcArea() {
        double p = calcPerimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void present() {
        System.out.println("I'm triangle");
    }

    @Override
    public void showPerimeter() {
        System.out.println(calcPerimeter());
    }
}
