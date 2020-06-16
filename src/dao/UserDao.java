package dao;

import entity.User;

public interface UserDao {
    User findUserByName(String name);
}
