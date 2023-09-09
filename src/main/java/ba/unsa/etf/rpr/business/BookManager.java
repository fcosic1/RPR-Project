package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

public class BookManager {
    public List<Book> getAll() throws ProjectException {
        return DaoFactory.bookDao().getAll();
    }
    public void delete(int id) throws ProjectException {
        DaoFactory.bookDao().delete(id);
    }
}
