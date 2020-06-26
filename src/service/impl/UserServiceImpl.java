package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.PageBean;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User loginByNameAndPassword(String name,String password) {
        return dao.loginByNameAndPassword(name,password);
    }

    @Override
    public List<User> findAllUser() {
        return dao.findAllUser();
    }

    @Override
    public Boolean addUser(User u) {
        return dao.addUser(u) == true;
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<User> pb = new PageBean<User>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<User>list = dao.findByPage(start,rows);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public User findUserByUserId(int user_id) {
        return dao.findUserByUserId(user_id);
    }

    @Override
    public User findUserByUserName(String userName) {
        return dao.findUserByUserName(userName);
    }

    @Override
    public List<User> findUserListByKey(String keywords) {
        return dao.findUserListByKey(keywords);
    }

    @Override
    public void delUserById(int uid) {
        dao.delUserById(uid);
    }

    @Override
    public void updatePasswordById(int user_id, String p) {
        dao.updatePasswordById(user_id,p);
    }

    @Override
    public void updatePhotoById(int userId, String fileName) {
        dao.updatePhotoById(userId,fileName);
    }

    @Override
    public void updateInfoById(int userId, String sex, String nickname) {
        dao.updateInfoById(userId, sex, nickname);
    }
}
