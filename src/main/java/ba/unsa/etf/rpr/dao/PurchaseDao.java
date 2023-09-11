package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.business.PurchaseTableView;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.Date;
import java.util.List;
/** Dao interface for Purchase domain*/
public interface PurchaseDao extends Dao<Purchase> {
    List<Purchase> getByBook(Book book) throws ProjectException;
    List<Purchase> getByUser(User user) throws ProjectException;
    List <Purchase> getByDate(Date date) throws ProjectException;

    List<PurchaseTableView> getMyBooks(String username) throws ProjectException;
}
