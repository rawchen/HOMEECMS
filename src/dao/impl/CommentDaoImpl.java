package dao.impl;

import dao.CommentDao;
import entity.Comment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Comment> findCommentByProductId(int productId) {
        try {
            String sql = "select * from tb_comment where product_id = ?";
            List<Comment> c = template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class),productId);
            return c;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
