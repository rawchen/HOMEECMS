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
}
