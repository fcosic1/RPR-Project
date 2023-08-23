package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Product;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

public interface ProductDao extends Dao<Product> {

    List<Product> searchByPrice(int pirce) throws ProjectException;
}
