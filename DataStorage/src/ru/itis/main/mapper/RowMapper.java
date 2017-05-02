package ru.itis.main.mapper;

/**
 * Интерфейс, описывающий функцию, которая отображает строку в объекте
 */
public interface RowMapper<T> {
    T mapRow(String row);
}
