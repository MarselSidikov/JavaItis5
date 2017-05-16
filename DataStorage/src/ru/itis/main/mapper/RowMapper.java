package ru.itis.main.mapper;

/**
 * Интерфейс, описывающий функцию, которая отображает строку в объект
 */
public interface RowMapper<T> {
    T mapRow(String row);
}
