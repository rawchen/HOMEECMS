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
        if (dao.addUser(u) == true) {
            return true;
        }else {
            return false;
        }
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
}
