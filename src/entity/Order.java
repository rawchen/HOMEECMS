package entity;

import java.util.Date;

public class Order {

    private int id;
    private String order_id;
    private int user_id;
    private int order_price;
    private Date order_time;
    private String is_pay;
    private String is_ship;
    private String is_receipt;
    private int address_id;
    private int product_id;
    private int product_quantity;
    private String product_name;
    private String product_photo;
    private int product_price;

    public Order(){

    }

    public Order(String order_id, int user_id, int order_price, Date order_time, String is_pay, String is_ship, String is_receipt,int product_id,int product_quantity) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_price = order_price;
        this.order_time = order_time;
        this.is_pay = is_pay;
        this.is_ship = is_ship;
        this.is_receipt = is_receipt;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(String is_pay) {
        this.is_pay = is_pay;
    }

    public String getIs_ship() {
        return is_ship;
    }

    public void setIs_ship(String is_ship) {
        this.is_ship = is_ship;
    }

    public String getIs_receipt() {
        return is_receipt;
    }

    public void setIs_receipt(String is_receipt) {
        this.is_receipt = is_receipt;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(String product_photo) {
        this.product_photo = product_photo;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", user_id=" + user_id +
                ", order_price=" + order_price +
                ", order_time=" + order_time +
                ", is_pay='" + is_pay + '\'' +
                ", is_ship='" + is_ship + '\'' +
                ", is_receipt='" + is_receipt + '\'' +
                ", address_id=" + address_id +
                ", product_id=" + product_id +
                ", product_quantity=" + product_quantity +
                ", product_name='" + product_name + '\'' +
                ", product_photo='" + product_photo + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
