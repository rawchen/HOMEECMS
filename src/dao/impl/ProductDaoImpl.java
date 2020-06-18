package dao.impl;

import dao.ProductDao;
import entity.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Product> findAllProduct() {
        try {
            String sql = "select * from tb_product";
            List<Product> p = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
            return p;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
