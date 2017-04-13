package ru.itis;

import javax.lang.model.element.TypeParameterElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class Main {

    public static void main(String[] args) throws Exception {
        // получили класс Human как объект
        // aClass - объектная переменная
        // указывающая на класс-объект
	    Class aClass = Class.forName("ru.itis.Human");
        // создание экземпляра класса
        // Human human = (Human)aClass.newInstance();
        Constructor<Human> constructor = aClass.getConstructor(Integer.TYPE, String.class);
        Human human = constructor.newInstance(23, "Marsel");
        System.out.println(human.getAge());

        Field fields[] = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }

        Field ageField = fields[0];
        ageField.setAccessible(true);
        ageField.set(human, -100);

        System.out.println(human.getAge());

        Human human1 = new Human(20, "Sasha");
        Method method = aClass.getMethod("aging");
        method.invoke(human1);
        System.out.println(human1.getAge());

        Constructor<Human> constructors[] = aClass.getConstructors();

        Class types[] = constructors[0].getParameterTypes();
        for (int i = 0; i < types.length; i++) {
            System.out.print(types[i] + " ");
        }

        Class stringClass = String.class;
    }
}
