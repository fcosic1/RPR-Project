package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookDaoSQLImplementation extends AbstractDao<Book> implements BookDao{
    private static BookDaoSQLImplementation instance = null;
    public static BookDaoSQLImplementation getInstance(){
        if(instance == null) instance = new BookDaoSQLImplementation();
        return instance;
    }
    public static void removeInstance(){

        if(instance!=null) instance=null;
    }

    public BookDaoSQLImplementation() {
        super("Book");
    }

    @Override
    public Book row2object(ResultSet rs) throws ProjectException {
        try {
            Book b = new Book();
            b.setId(rs.getInt("id"));
            b.setBookTitle(rs.getString("bookTitle"));
            b.setPrice(rs.getDouble("price"));
            b.setAuthor(rs.getString("author"));
            b.setAgeOfBook(rs.getDate("ageOfBook"));
            b.setBookType(rs.getString("bookType"));
            return b;
        } catch (SQLException e) {
            throw new ProjectException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Book object) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", object.getId());
        map.put("bookTitle", object.getBookTitle());
        map.put("ageOfBook", object.getAgeOfBook());
        map.put("price", object.getPrice());
        map.put("author", object.getAuthor());
        map.put("bookType",object.getBookType());
        return map;
    }


    @Override
    public List<Book> searchByBookTitle(String bookTitle) throws ProjectException {
        return executeQuery("select * from Book where bookTitle LIKE concat('%',?,'%')",new Object[]{bookTitle});

    }

    @Override
    public List<Book> searchByAuthor(String author) throws ProjectException {
        return executeQuery("select * from Book where author LIKE concat('%',?,'%')",new Object[]{author});

    }


}
