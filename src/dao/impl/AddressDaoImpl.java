package dao.impl;

import dao.AddressDao;
import entity.Address;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Address> findAddressByUserId(int user_id) {
        try {
            String sql = "select * from tb_address where user_id = ?";
            List<Address> a = template.query(sql, new BeanPropertyRowMapper<Address>(Address.class),user_id);
            return a;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
