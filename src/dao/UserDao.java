package dao;

import entity.User;

public interface UserDao {
    User loginByNameAndPassword(String name,String password);
}
