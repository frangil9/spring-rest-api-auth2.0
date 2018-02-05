package com.group.system.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,ID extends Serializable> {
    void saveOrUpdate(T entity);
    Serializable save(T entity);
    void update(T entity);
    T findById(ID id);
    void delete(T entity);
    List<T> findAll();
}
