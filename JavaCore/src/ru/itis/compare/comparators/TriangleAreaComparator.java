package ru.itis.compare.comparators;


import ru.itis.compare.interfaces.Comparator;
import ru.itis.compare.models.Triangle;

public class TriangleAreaComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle a, Triangle b) {
        return (int)(a.calcArea() - b.calcArea());
    }
}
