package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;

public class DaoFactory {
    private static final UserDao userDao = new UserDaoSQLImplementation();
    private static final BookDao bookDao = new BookDaoSQLImplementation();

    private static final PurchaseDao purchaseDao = new PurchaseDaoSQLImplementation();
    private DaoFactory(){}
    public static UserDao userDao(){
        return userDao;
    }
    public static BookDao bookDao(){
        return bookDao;
    }
    public static PurchaseDao purchaseDao(){
        return purchaseDao;
    }
}
