package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.Date;
import java.util.List;
/** Dao interface for Book domain*/
public interface BookDao extends Dao<Book> {
    List<Book> searchByBookTitle(String bookTitle) throws ProjectException;
    List<Book> searchByAuthor(String author) throws ProjectException;
    List<Book> getBookByDate(Date date) throws ProjectException;
    List<Book> getBooksCheaperThan(double price) throws ProjectException;
    List<Book> getBooksByBooksType(String bookType) throws ProjectException;

}
