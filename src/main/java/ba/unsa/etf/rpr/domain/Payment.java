package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Payment implements Idable{

    private int id;
    private int userId;
    private int productId;
    private String paymentMethod;
    private Date paymentDate;

    public Payment(int id, String paymentMethod, Date paymentDate, int userId, int productId){
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.userId = userId;
        this.productId = productId;
    }
    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public Date getPaymentDate(){
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate){
        this.paymentDate = paymentDate;
    }
    public int getProductId(){
        return productId;
    }
    public void setProductId(int productId){
        this.productId = productId;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id;
    }

}
