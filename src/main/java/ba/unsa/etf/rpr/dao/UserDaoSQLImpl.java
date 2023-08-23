package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    private static UserDaoSQLImpl instance = null;
    private UserDaoSQLImpl(){
        super("User");
    }

}
