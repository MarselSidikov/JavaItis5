package ru.itis.abstracts;

/**
 * 22.04.2017
 * AbstractFigure
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class AbstractFigure implements Figure {
    public boolean equals(Object object) {
        if (object != null && object instanceof Figure) {
            Figure that = (Figure)object;
            return this.area() == that.area();
        } else return false;
    }
}
