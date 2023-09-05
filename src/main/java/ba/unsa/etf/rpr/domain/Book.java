package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Book implements Idable{

    private int id;
    private String bookTitle;
    private Date ageOfBook;
    private String author;
    private double price;
    private String bookType;


    public Book(int book_id, String bookTitle, Date ageOfBook, String author, double price, String bookType){
        this.id = book_id;
        this.bookTitle = bookTitle;
        this.ageOfBook = ageOfBook;
        this.author = author;
        this.price = price;
        this.bookType = bookType;
    }
    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }
}
