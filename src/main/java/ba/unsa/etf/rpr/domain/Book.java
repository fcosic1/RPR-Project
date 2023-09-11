package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Book implements Idable{

    private int id;
    private String bookTitle;
    private Date ageOfBook;
    private String author;
    private double price;
    private String bookType;


    public Book(int book_id, String bookTitle, double price, String author ,Date ageOfBook, String bookTypeID){
        this.id = book_id;
        this.bookTitle = bookTitle;
        this.price = price;
        this.author = author;
        this.ageOfBook = ageOfBook;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() && getBookTitle() == book.getBookTitle() && Double.compare(book.getPrice(), getPrice()) == 0  && getBookType() == book.getBookType() && Objects.equals(getAgeOfBook(), book.getAgeOfBook()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookTitle(), getAgeOfBook(), getAuthor(), getPrice(), getBookType());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "bookTitle=" + bookTitle +
                ", ageOfBook=" + ageOfBook +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", bookType=" + bookType +
                '}';
    }
    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }


}
