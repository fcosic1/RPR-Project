package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Purchase;

public class PurchaseDaoSQLImplementation extends AbstractDao<Purchase> implements PurchaseDao {
    private static PurchaseDaoSQLImplementation instance = null;

    public static PurchaseDaoSQLImplementation getInstance(){
        if(instance == null) instance = new PurchaseDaoSQLImplementation();
        return instance;
    }
    public static void removeInstance(){
        if(instance != null) instance = null;
    }
}
