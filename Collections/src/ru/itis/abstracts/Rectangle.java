package ru.itis.abstracts;

/**
 * 22.04.2017
 * Rectangle
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Rectangle extends AbstractFigure {
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
    public int area() {
        return a * b;
    }
}
