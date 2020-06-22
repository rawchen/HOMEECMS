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
            template.update(sql,p.getProduct_name(),p.getProduct_info(),p.getProduct_price(),p.getProduct_stock(),p.getProduct_fid(),p.getProduct_cid(),p.getProduct_photo(),p.getProduct_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delProductById(int productId) {
        try {
            String sql = "delete from tb_product where product_id=?";
            template.update(sql,productId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProduct(Product p) {
        try {
            String sql = "insert into tb_product(product_name,product_info,product_price,product_stock,product_fid,product_cid,product_photo,product_time) values(?,?,?,?,?,?,?,?)";
            template.update(sql,p.getProduct_name(),p.getProduct_info(),p.getProduct_price(),p.getProduct_stock(),p.getProduct_fid(),p.getProduct_cid(),p.getProduct_photo(),p.getProduct_time());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findProductByCategoryCid(int productCid) {
        try {
            String sql = "select * from tb_product where product_cid = ?";
            List<Product> p = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class),productCid);
            return p;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findProductTimeSort() {
        try {
            String sql = "select * from tb_product order by product_time desc limit 6";
            List<Product> p = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
            return p;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findProductSalesSort() {
        try {
            String sql = "select * from tb_product order by product_sales desc limit 9";
            List<Product> p = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
            return p;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findProductByCategoryFid(int productFid) {
        try {
            String sql = "select * from tb_product where product_fid = ?";
            List<Product> p = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class),productFid);
            return p;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
