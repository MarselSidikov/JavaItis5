package ru.itis.zoo;

import ru.itis.models.Animal;

/**
 * Зоопарк животных
 * @param <T> - тип животных, допустимых в зоопарке
 */
public interface Zoo<T extends Animal> {
    void add(T animal);
}
