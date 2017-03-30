package ru.itis.string;


public class MainString {
    public static void main(String[] args) {
        // "Hello!" - литеральная строка
        // если компилятор видит, что есть одинаковые литеральные строки
        // то он для них создает один объект
        // и помещает его в StringPool
        String a = "Hello!";
        String b = "Hello!";

        System.out.println(a == b);

        // явно создали два объекта
        String x = new String("Hello!");
        String y = new String("Hello!");

        System.out.println(x == y);
        System.out.println(x.equals(y));

        String internedX = x.intern();
        String internedY = y.intern();

        System.out.println(internedX + " " + internedY);

        System.out.println(internedX == internedY);
    }
}
