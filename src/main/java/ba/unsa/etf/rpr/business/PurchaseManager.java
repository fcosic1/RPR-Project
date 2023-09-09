package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

public class PurchaseManager {
    public List<Purchase> getAll() throws ProjectException {
        return DaoFactory.purchaseDao().getAll();
    }
    public void delete(int id) throws ProjectException {
        DaoFactory.purchaseDao().delete(id);
    }
    public Purchase add(Purchase item) throws ProjectException {
        return DaoFactory.purchaseDao().add(item);
    }
    public Purchase update(Purchase item) throws ProjectException {
        return DaoFactory.purchaseDao().update(item);
    }
}
