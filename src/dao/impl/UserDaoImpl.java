package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User loginByNameAndPassword(String n,String p) {
        try {
            String sql = "select * from tb_user where user_name = ? and user_password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),n,p);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAllUser() {
        try {
            String sql = "select * from tb_user";
            List<User> u = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return u;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUser(User u) {
        Boolean flag = true;
        try {
            String sql = "insert into tb_user(user_name,user_nickname,user_password,user_sex,user_vip,user_viptime,user_status,user_photo) values(?,?,?,?,?,?,?,?)";
            template.update(sql,u.getUser_name(),u.getUser_nickname(),u.getUser_password(),u.getUser_sex(),u.getUser_vip(),u.getUser_viptime(),u.getUser_status(),u.getUser_photo());
        } catch (DataAccessException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tb_user";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "select * from tb_user limit ? , ?";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class),start,rows);
    }
}
