package ru.itis.zoo;

import ru.itis.models.Herbivore;

public class ZooNotForChildrenHaha extends ZooForChildren {
    public void touch(Herbivore herbivore) {
        System.out.println("KILL YOU!");
    }
}
