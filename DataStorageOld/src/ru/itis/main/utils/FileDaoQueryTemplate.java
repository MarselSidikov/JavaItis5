package ru.itis.main.utils;

import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Model;

import java.util.List;

/**
 * 29.04.2017
 * FileDaoQueryTemplate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileDaoQueryTemplate {
    /**
     * Вытаскивает все данные из файла как список моделей
     * @param fileName имя файла
     * @param mapper функция отображения строки файла в модель
     * @param <T> тип модели
     * @return список моделей
     */
    <T> List<T> findAll(String fileName, RowMapper<T> mapper);

    /**
     * Возвращает список тех моделей, которые удовлетворяют условию по значению
     * @param fileName имя файла
     * @param mapper функция отображения строки файла в объект
     * @param valueColumn номер колонки в котором содержится значение
     * @param value значение, которому удовлетворяет строка в позиции valueColumn
     * @param <T> тип модели
     * @return
     */
    <T> List<T> findByValue(String fileName, RowMapper<T> mapper,
                                   int valueColumn,
                                   Object value);

    <T> int save(String fileName, T model);
    <T> void update(String fileName, T model);
    void deleteByValue(String fileName, int valueColumn, Object value);
}
