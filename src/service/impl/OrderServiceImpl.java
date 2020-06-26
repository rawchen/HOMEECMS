package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import entity.PageBean;
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

    @Override
    public List<Order> findAllOrder() {
        return dao.findAllOrder();
    }

    @Override
    public PageBean<Order> findOrderByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<Order> pb = new PageBean<Order>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Order>list = dao.findByPage(start,rows);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public List<Order> findOrderListByKey(String keywords) {
        return dao.findOrderListByKey(keywords);
    }

    @Override
    public List<Order> findOrderByUserIdAndIsReceipt(int user_id) {
        return dao.findOrderByUserIdAndIsReceipt(user_id);
    }
}
