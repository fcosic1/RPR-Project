package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PurchaseDaoSQLImplementation extends AbstractDao<Purchase> implements PurchaseDao {
    private static PurchaseDaoSQLImplementation instance = null;

    public static PurchaseDaoSQLImplementation getInstance(){
        if(instance == null) instance = new PurchaseDaoSQLImplementation();
        return instance;
    }
    public static void removeInstance(){
        if(instance != null) instance = null;
    }
    public PurchaseDaoSQLImplementation(){
        super("Purchase");
    }
    @Override
    public List<Purchase> getByBook(Book book) throws ProjectException {
        List<Purchase> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement("select * from Purchase where book = ?");
            s.setInt(1, book.getId());
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ProjectException(e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Purchase> getByUser(User user) throws ProjectException {
        List<Purchase> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement("select * from Purchase where user = ?");
            s.setInt(1, user.getId());
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ProjectException(e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Purchase> getByDate(Date date) throws ProjectException {
        List<Purchase> list = new ArrayList<>();
        try{
            PreparedStatement s = getConnection().prepareStatement("select * from Purchase where dateOfRent = ?");
            s.setDate(1, (java.sql.Date) date);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                list.add(row2object(rs));
            }
            rs.close();
        }catch (SQLException e){
            throw new ProjectException(e.getMessage(),e);
        }
        return list;
    }

    @Override
    public Purchase row2object(ResultSet rs) throws ProjectException {
        try{
            Purchase p = new Purchase();
            p.setId(rs.getInt("id"));
            p.setUser(DaoFactory.userDao().getById(rs.getInt("user")));
            p.setBook(DaoFactory.bookDao().getById(rs.getInt("book")));
            p.setDateOfRent(rs.getDate("dateOfRent"));
            return p;
        } catch (SQLException e) {
            throw new ProjectException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Purchase object) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", object.getId());
        map.put("book", object.getBook().getId());
        map.put("dateOfRent", object.getDateOfRent());
        map.put("user",object.getUser().getId());
        return map;
    }
}
