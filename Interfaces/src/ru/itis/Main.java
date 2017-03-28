package ru.itis;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(2, 3,4);
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(5, 5);
        Square square = new Square(6);

        Figure figures[] = {triangle, circle, rectangle, square};
        for (int i = 0; i < figures.length; i++) {
            System.out.println(figures[i].calcArea());
        }

        Presentable circlePresentable = circle;

        circlePresentable.present();

        Presentable trianglePresentable = triangle;
        trianglePresentable.present();

        FigurePresentable figurePresentable = triangle;
        figurePresentable.showPerimeter();
    }
}
