package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    public static UserDao userDao() {
        return userDao;
    }

}
