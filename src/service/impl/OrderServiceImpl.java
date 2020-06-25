package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();

    @Override
    public void addOrder(Order order) {
        dao.addOrder(order);
    }

    @Override
    public Order findOrderById(String oid) {
        return dao.findOrderById(oid);
    }

    @Override
    public void updateOrderAddress(String oid, int addressid) {
        dao.updateOrderAddress(oid,addressid);
    }

    @Override
    public void updateOrderIsPay(String oid, String s) {
        dao.updateOrderIsPay(oid,s);
    }

    @Override
    public List<Order> findOrderByUserId(int user_id) {
        return dao.findOrderByUserId(user_id);
    }
}
