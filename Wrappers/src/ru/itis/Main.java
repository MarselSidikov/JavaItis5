package ru.itis;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(6);

        // boxing
        Integer a2 = new Integer(67);

        // autoboxing
        Integer a = 67;

        // autounboxing
        int x = a;

        // unboxing
        x = a.intValue();
    }
}
