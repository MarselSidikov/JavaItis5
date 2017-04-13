package ru.itis;

/**
 * 07.04.2017
 * Human
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void aging() {
        this.age = age + 1;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
       if (this.getClass().getName().equals(o.getClass().getName())) {
           return true;
       }

       return false;
    }

}
