package ba.unsa.etf.rpr.business;

import java.util.Date;
/**Helping class for TableView in MyBooks section*/
public class PurchaseTableView {

    private String bookTitle;
    private String author;
    private String bookType;
    private Date purchase_date;
    private double price;

    public PurchaseTableView(String bookTitle, double price, String author, Date date, String bookType) {
        this.bookTitle=bookTitle;
        this.price=price;
        this.author=author;
        this.purchase_date = date;
        this.bookType=bookType;
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
