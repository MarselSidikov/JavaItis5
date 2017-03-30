package ru.itis.compare.comparators;

import ru.itis.compare.interfaces.Comparator;
import ru.itis.compare.models.Human;

public class HumanIdComparator implements Comparator<Human> {
    @Override
    public int compare(Human a, Human b) {
        return a.getId() - b.getId();
    }
    /*
    public int compare(Object a, Object b) {
        if (a instanceof Human && b instanceof Human) {
            Human humanA = (Human)a;
            Human humanB = (Human)b;
            return humanA.getId() - humanB.getId();
        } else {
            System.out.println("Cannot cast");
            return 0;
        }
    }*/


}
