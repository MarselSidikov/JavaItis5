package ru.itis.main.dao;

import java.util.List;

public interface BaseCrudDao<T> {
    T find(int id);
    int save(T model);
    void delete(int id);
    void update(T model);

    List<T> findAll();
}



















