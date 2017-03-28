package ru.itis.compare;

public class Human implements Comparable {
    private int id;
    private int age;
    private String name;

    public Human(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || !(object instanceof Human)) {
            return false;
        } else {
            Human that = (Human)object;
            return this.age == that.age
                    && this.id == that.id
                    && this.name.equals(that.name);
        }
    }

    public String toString() {
        return this.name + " " + this.age + " " + this.id;
    }

    /**
     * Метод сравнивает два объекта-человека по возрасту
     * @param that другой человек
     * @return 0 - если равны, отрицательное число - меньше, положительное - больше
     */
    public int compareTo(Human that) {
        return this.age - that.age;
    }

    @Override
    public int compareTo(Object that) {
        return this.age - ((Human)that).age;
    }
}
