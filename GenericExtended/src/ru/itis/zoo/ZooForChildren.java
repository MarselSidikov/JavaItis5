package ru.itis.zoo;

import ru.itis.models.Herbivore;

public class ZooForChildren<T extends Herbivore> implements Zoo<T> {

    private Herbivore herbivores[];
    private int count;

    public ZooForChildren() {
        herbivores = new Herbivore[5];
        count = 0;
    }

    @Override
    public void add(T animal) {
        herbivores[count] = animal;
        count++;
    }

    public void touch(T animal) {
        for (int i = 0; i < count; i++) {
            if (animal.equals(herbivores[i])) {
                herbivores[i].mimi();
                return;
            }
        }
        System.err.println(animal + " not found");
    }

    public T get(String name) {
        for (int i = 0; i < count; i++) {
            if (name.equals(herbivores[i].getName())) {
                return (T)herbivores[i];
            }
        }

        return null;
    }

}
