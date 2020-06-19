package servlet.user;

import entity.PageBean;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpage = 1; //当前页
        int count = 5; //每页显示条数

        //获取用户指定的页面
        String cp = request.getParameter("cp");

        //接收用户搜索的关键字
        String keyword = request.getParameter("keywords");

        if(cp!=null) {
            cpage = Integer.parseInt(cp);
        }


        /*****************************************************/
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows);
        request.setAttribute("pb",pb );

        List<User> list = service.findAllUser();

        //放到请求对象域里
        request.setAttribute("userlist", list);
//        request.setAttribute("tsum", arr[0]);
//        request.setAttribute("tpage", arr[1]);
        request.setAttribute("cpage", cpage);



        if(keyword != null) {
            request.setAttribute("searchParams", "&keywords="+keyword);
        }

        request.getRequestDispatcher("manage/admin_user.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
