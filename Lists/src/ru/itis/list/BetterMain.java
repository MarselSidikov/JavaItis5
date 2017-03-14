package ru.itis.list;

import ru.itis.list.ArrayList;

/**
 * 14.03.2017
 * BetterMain
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BetterMain {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.addToEnd(10);
        array.addToEnd(15);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);
        array.addToEnd(10);

        ArrayList otherArray = new ArrayList();
        otherArray.addToEnd(1);
        otherArray.addToEnd(5);
        otherArray.addToEnd(0);
        otherArray.addToBegin(11);

        otherArray.addByIndex(777, 3);

        otherArray.reverse();

        array.show();
        otherArray.show();
    }
}
