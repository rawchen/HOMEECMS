package service;

import entity.PageBean;
import entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User loginByNameAndPassword(String name,String password);

    List<User> findAllUser();

    Boolean addUser(User u);

    PageBean<User> findUserByPage(String currentPage,String rows);

    User findUserByUserId(int user_id);

    User findUserByUserName(String userName);

    List<User> findUserListByKey(String keywords);
}
