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
}
