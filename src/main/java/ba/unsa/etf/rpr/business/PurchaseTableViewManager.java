package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;
/** Business logic layer for TableView in MyBooks section*/
public class PurchaseTableViewManager {
    public List<PurchaseTableView> getMyBooks(String username) throws ProjectException {
        return DaoFactory.purchaseDao().getMyBooks(username);
    }
}
