package dao.impl;

import dao.OrderDao;
import entity.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

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

    @Override
    public Order findOrderById(String oid) {
        try {
            String sql = "select * from tb_order where order_id = ?";
            Order o = template.queryForObject(sql, new BeanPropertyRowMapper<Order>(Order.class),oid);
            return o;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateOrderAddress(String oid, int addressid) {
        try {
            String sql = "update tb_order set address_id = ? where order_id = ?";
            template.update(sql,addressid,oid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderIsPay(String oid, String s) {
        try {
            String sql = "update tb_order set is_pay = ? where order_id = ?";
            template.update(sql,s,oid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findOrderByUserId(int user_id) {
        try {
            String sql = "select * from tb_order where user_id = ?";
            List<Order> orders = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),user_id);
            return orders;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
