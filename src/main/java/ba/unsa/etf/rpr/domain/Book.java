package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Book implements Idable{

    private int id;
    private String bookTitle;
    private Date ageOfBook;
    private String author;
    private double price;
    private String bookType;


    public Book(int book_id, String bookTitle, Date ageOfBook, String author, double price, String bookTypeID){
        this.id = book_id;
        this.bookTitle = bookTitle;
        this.ageOfBook = ageOfBook;
        this.author = author;
        this.price = price;
        this.bookType = bookTypeID;
    }

    public Book(){
        this.id = 0;
        this.bookTitle = "";
        this.ageOfBook = new Date();
        this.author = "";
        this.price = 0;
        this.bookType = "";
    }


    public String getBookTitle() { return bookTitle;}
    public void setBookTitle(String bookTitle){ this.bookTitle = bookTitle;}
    public Date getAgeOfBook() {return ageOfBook;}
    public void setAgeOfBook(Date ageOfBook){this.ageOfBook = ageOfBook;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}
    public String getBookType() {return bookType;}
    public void setBookType(String bookTypeId) {this.bookType = bookTypeId;}
    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }


}
