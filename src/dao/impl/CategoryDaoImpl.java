package dao.impl;

import dao.CategoryDao;
import entity.Category;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findCategoryParentList() {
        try {
            String sql = "select * from tb_category where category_parentid=0";
            List<Category> c = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
            return c;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> findCategoryChildList() {
        try {
            String sql = "select * from tb_category where category_parentid!=0";
            List<Category> c = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
            return c;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> findAllCategory() {
        try {
            String sql = "select * from tb_category";
            List<Category> c = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
            return c;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    //通过子类找父类，未实现
    @Override
    public Category findCategoryByCid(int productCid) {
        try {
            String sql = "select * from tb_category where category_id = ?";
            Category category = template.queryForObject(sql,new BeanPropertyRowMapper<Category>(Category.class),productCid);
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCategory(Category category) {
        try {
            String sql = "insert into tb_category(category_name,category_parentid) values(?,?)";
            template.update(sql,category.getCategory_name(),category.getCategory_parentid());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delCategoryById(int cid2) {
        try {
            String sql = "delete from tb_category where category_id = ?";
            template.update(sql,cid2);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
