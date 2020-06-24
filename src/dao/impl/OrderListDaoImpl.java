package dao.impl;

import dao.OrderListDao;
import entity.OrderList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class OrderListDaoImpl implements OrderListDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addOrderList(OrderList o) {
        try {
            String sql = "insert into tb_orderlist(order_id,product_id,product_quantity) values(?,?,?)";
            template.update(sql,o.getOrder_id(),o.getProduct_id(),o.getProduct_quantity());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
