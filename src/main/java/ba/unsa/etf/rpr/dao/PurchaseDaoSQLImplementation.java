package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
