package service;

import entity.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    Order findOrderById(String oid);

    void updateOrderAddress(String oid, int addressid);

    void updateOrderIsPay(String oid, String s);

    List<Order> findOrderByUserId(int user_id);
}
