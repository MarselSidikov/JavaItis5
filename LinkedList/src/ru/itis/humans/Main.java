package ru.itis.humans;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Human humans[] = new Human[1000];
        Random random = new Random();
        for (int i = 0; i < humans.length; i++) {
            humans[i] = new Human("Human" + i, random.nextInt(120));
        }

        LinkedList buckets[] = new LinkedList[121];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList();
        }

        for (int i = 0; i < humans.length; i++) {
            int currentAge = humans[i].getAge();
            buckets[currentAge].addToTail(humans[i]);
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[0].addList(buckets[i]);
        }

        buckets[0].show();
    }
}
