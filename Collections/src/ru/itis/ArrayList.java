package ru.itis;

/**
 * 20.04.2017
 * ArrayList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayList<T> implements List<T> {

    private int MAX_SIZE = 10;

    /**
     * Хранилище элементов
     */
    private Object elements[];

    /**
     * Количество элементов
     */
    private int count;

    public ArrayList() {
        count = 0;
        elements = new Object[MAX_SIZE];
    }

    @Override
    public void add(T element) {
        if (count < MAX_SIZE) {
            this.elements[count] = element;
            count++;
        } else throw new ArrayStoreException();
    }

    @Override
    public void delete(T element) {

    }

    @Override
    public void removeByIndex(int index) {

    }

    @Override
    public T get(int index) {
        if (index < count && index >= 0) {
            return (T)elements[index];
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addToBegin(T element) {
        if (count < MAX_SIZE) {
            for (int i = count; i > 0; i--) {
                elements[i] = elements[i - 1];
            }
            elements[0] = element;
        }
    }
}
