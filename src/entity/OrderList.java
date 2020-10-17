package entity;

public class OrderList {

    private int id;
    private String order_id;
    private int product_id;
    private String product_quantity;

    public OrderList(){

    }

    public OrderList(String order_id, int product_id, String product_quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "order_id='" + order_id + '\'' +
                ", product_id=" + product_id +
                ", product_quantity='" + product_quantity + '\'' +
                '}';
    }
}
