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

    void delUserById(int uid);

    void updatePasswordById(int user_id, String p);

    void updatePhotoById(int userId, String fileName);

    void updateInfoById(int userId, String sex, String nickname);

    void updateUserById(User u);
}
