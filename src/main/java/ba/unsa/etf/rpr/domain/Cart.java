package ba.unsa.etf.rpr.domain;

public class Cart implements Idable{

    private int id;
    private int productId;
    private int cost;

    public Cart(){

    }
    public Cart(int productId, int cost){
        this.productId = productId;
        this.cost = cost;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    public int getProductId(){
        return productId;
    }
    public void setProductId(int productId){
        this.productId = productId;
    }
    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id;
    }
}
