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

    @Override
    public Product findProductById(int pId) {
        try {
            String sql = "select * from tb_product where product_id = ?";
            Product p = template.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class),pId);
            return p;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateProductById(Product p) {
        try {
            String sql = "update tb_product set product_name =?,product_info=?,product_price=?,product_stock=?,product_fid=?,product_cid=?,product_photo=? where product_id=?";
            template.update(sql,p.getProduct_name(),student.getS_sex(),student.getS_age(),student.getS_phone(),student.getS_email(),student.getS_address(),student.getS_college(),student.getS_department(),student.getS_class(),student.getS_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
