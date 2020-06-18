package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    User loginByNameAndPassword(String name,String password);

    List<User> findAllUser();

    boolean addUser(User u);

    int findTotalCount();

    List<User> findByPage(int start, int rows);
}
