package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User loginByNameAndPassword(String name,String password) {
        return dao.loginByNameAndPassword(name,password);
    }
}
