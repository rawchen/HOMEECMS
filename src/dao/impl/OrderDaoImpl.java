package dao.impl;

import dao.OrderDao;
import entity.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addOrder(Order o) {
        try {
            String sql = "insert into tb_order(order_id,user_id,order_price,order_time,is_pay,is_ship,is_receipt) values(?,?,?,?,?,?,?)";
            template.update(sql,o.getOrder_id(),o.getUser_id(),o.getOrder_price(),o.getOrder_time(),o.getIs_pay(),o.getIs_ship(),o.getIs_receipt());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
