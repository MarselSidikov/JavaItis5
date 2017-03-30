package ru.itis.object;

import ru.itis.compare.models.Human;

public class MainEquals {
    public static void main(String[] args) {
        Human a = new Human(1, 23, "Marsel");
        Human otherA = a;

        System.out.println(a == otherA);

        Human b = new Human(1, 23, "Marsel");

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
