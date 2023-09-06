package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> searchByFirstName(String firstName) throws ProjectException;
    List<User> searchByLastName(String lastName) throws ProjectException;
    User searchByUsername(String username) throws ProjectException;
}
