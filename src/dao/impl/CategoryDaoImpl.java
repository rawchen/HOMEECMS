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
    public Category findCategoryFidByCid(int productCid) {
        Category category = new Category();
        category.setCategory_parentid(1);
        return category;
    }
}
