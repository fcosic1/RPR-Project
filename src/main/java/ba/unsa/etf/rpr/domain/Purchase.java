package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/** Klasa koja sadrzi sve kupovine knjige */
public class Purchase implements Idable{

    private int id;
    private Book book;
    private User user;
    private Date dateOfRent;



    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    public Purchase(){

    }

    public Purchase(Book book, User user, Date dateOfRent){
        this.book = book;
        this.user = user;
        this.dateOfRent = dateOfRent;
    }

    public Book getBook(){
        return book;
    }
    public void setBook(Book book){
        this.book = book;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public Date getDateOfRent(){
        return dateOfRent;
    }
    public void setDateOfRent(Date dateOfRent){
        this.dateOfRent = dateOfRent;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return getId() == purchase.getId() && Objects.equals(getBook(), purchase.getBook()) && Objects.equals(getUser(), purchase.getUser()) && Objects.equals(getDateOfRent(), purchase.getDateOfRent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBook(), getUser(), getDateOfRent());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", dateOfRent=" + dateOfRent +
                '}';
    }
}
