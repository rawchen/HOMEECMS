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
        try {
            String sql = "select count(*) from tb_user";
            return template.queryForObject(sql, Integer.class);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        try {
            String sql = "select * from tb_user limit ? , ?";
            return template.query(sql, new BeanPropertyRowMapper<User>(User.class),start,rows);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserByUserId(int user_id) {
        try {
            String sql = "select * from tb_user where user_id = ?";
            User u = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user_id);
            return u;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserByUserName(String userName) {
        try {
            String sql = "select * from tb_user where user_name = ?";
            User u = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),userName);
            return u;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findUserListByKey(String keywords) {
        try {
            String sql = "select * from tb_user where user_name like '%' ? '%' or user_nickname like '%' ? '%'";
            List<User> user = template.query(sql,new BeanPropertyRowMapper<User>(User.class),keywords,keywords);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delUserById(int uid) {
        try {
            String sql = "delete from tb_user where user_id=?";
            template.update(sql,uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePasswordById(int user_id, String p) {
        try {
            String sql = "update tb_user set user_password = ? where user_id = ?";
            template.update(sql,p,user_id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhotoById(int userId, String fileName) {
        try {
            String sql = "update tb_user set user_photo = ? where user_id = ?";
            template.update(sql,fileName,userId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInfoById(int userId, String sex, String nickname) {
        try {
            String sql = "update tb_user set user_sex = ?,user_nickname = ? where user_id = ?";
            template.update(sql,sex,nickname,userId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserById(User u) {
        try {
            String sql = "update tb_user set user_name =?,user_nickname=?,user_password=?,user_sex=?,user_vip=?,user_viptime=?,user_photo=? where user_id=?";
            template.update(sql,u.getUser_name(),u.getUser_nickname(),u.getUser_password(),u.getUser_sex(),u.getUser_vip(),u.getUser_viptime(),u.getUser_photo(),u.getUser_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
