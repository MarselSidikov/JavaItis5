package ru.itis.compare;

public class Triangle implements Comparable {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double calcPerimeter() {
        return a + b + c;
    }


    public double calcArea() {
        double p = calcPerimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void present() {
        System.out.println("I'm triangle");
    }

    public void showPerimeter() {
        System.out.println(calcPerimeter());
    }

    public int compareTo(Triangle that) {
        return (int)(this.calcPerimeter() - that.calcPerimeter());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public int compareTo(Object that) {
        return (int)(this.calcPerimeter() - ((Triangle)that).calcPerimeter());
    }
}
