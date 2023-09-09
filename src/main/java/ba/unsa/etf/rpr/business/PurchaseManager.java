package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

public class PurchaseManager {
    public List<Purchase> getAll() throws ProjectException {
        return DaoFactory.purchaseDao().getAll();
    }
}
