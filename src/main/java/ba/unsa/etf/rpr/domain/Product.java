package ba.unsa.etf.rpr.domain;

public class Product implements Idable{

    private int id;
    private String description;
    private double price;
    private byte[] picture;

    public Product(){

    }

    public Product(double price, String description){
        this.price = price;
        this.description = description;
    }
    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public byte[] getPicture(){
        return picture;
    }
    public void setPicture(byte[] picture){
        this.picture = picture;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product p = (Product) o;
        return id == p.id;
    }
}
