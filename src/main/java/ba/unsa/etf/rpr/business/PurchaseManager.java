package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;
/**
 * Business Logic Layer for management of Purchases
 */
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
    /** Da li je kupovina izvrsena*/
    public void isPurchaseAlreadyMade(User user, Book book) {

        PurchaseManager purchaseManager = new PurchaseManager();
        List<Purchase> purchaseList = purchaseManager.getAll();


        for (int i = 0; i < purchaseList.size(); i++) {
            if (purchaseList.get(i).getBook().getId() == book.getId() && purchaseList.get(i).getUser().getId() == user.getId()) {
                throw new ProjectException("This purchase has already been made");
            }
        }
    }
}
