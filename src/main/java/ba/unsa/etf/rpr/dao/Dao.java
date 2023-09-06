package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;

import java.util.List;

public interface Dao<type> {

    type getById(int id);
    type add(type item);
    type update(type item);
    void delete(int id);
    List<type> getAll();
}
