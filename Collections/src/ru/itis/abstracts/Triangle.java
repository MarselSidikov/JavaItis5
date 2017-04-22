package ru.itis.abstracts;

/**
 * 22.04.2017
 * Triangle
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Triangle extends AbstractFigure {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public int area() {
        int p = (a + b + c) / 2;
        return (int)Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
