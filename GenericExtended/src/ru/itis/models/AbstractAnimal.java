package ru.itis.models;

public abstract class AbstractAnimal implements Animal {

    private String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof Animal) {
            Animal that = (Animal)object;
            return this.name.equals(that.getName());
        } else return false;
    }

    public String toString() {
        return this.name;
    }


}
