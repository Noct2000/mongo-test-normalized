package com.example.mongotestnormalized.service;

import java.util.List;

public interface CrudService<T, I> {
    T save(T entity);

    List<T> getAll();

    T getById(I id);

    T update(T entity);

    boolean deleteById(I id);
}
