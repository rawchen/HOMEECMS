package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();

    @Override
    public void addOrder(Order order) {
        dao.addOrder(order);
    }
}
