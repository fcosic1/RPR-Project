package ba.unsa.etf.rpr.business;

import java.util.Date;

public class PurchaseTableView {

    private String bookTitle;
    private String author;
    private String bookType;
    private Date purchase_date;
    private double price;

    public PurchaseTableView(String bookTitle, String author, String bookType, double price, Date date) {
        this.bookTitle=bookTitle;
        this.author=author;
        this.bookType=bookType;
        this.price=price;
        this.purchase_date=date;
    }
    public PurchaseTableView() {

    }
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
