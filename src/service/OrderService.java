package service;

import entity.Order;
import entity.PageBean;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    Order findOrderById(String oid);

    void updateOrderAddress(String oid, int addressid);

    void updateOrderIsPay(String oid, String s);

    List<Order> findOrderByUserId(int user_id);

    List<Order> findAllOrder();

    PageBean<Order> findOrderByPage(String currentPage, String rows);

    List<Order> findOrderListByKey(String keywords);

    List<Order> findOrderByUserIdAndIsReceipt(int user_id);
}
