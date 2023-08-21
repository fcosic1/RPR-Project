package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;
public interface Dao<T> {
    T getById(int id) throws ProjectException;
    T add(T item) throws ProjectException;
    T update(T item) throws ProjectException;
    void delete(int id) throws ProjectException;
    List<T> getAll() throws ProjectException;
}
