package service.impl;

import dao.OrderListDao;
import dao.impl.OrderListDaoImpl;
import entity.OrderList;
import service.OrderListService;

public class OrderListServiceImpl implements OrderListService {
    OrderListDao dao = new OrderListDaoImpl();

    @Override
    public void addOrderList(OrderList orderList) {
        dao.addOrderList(orderList);
    }
}
