package servlet.user;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        UserService service = new UserServiceImpl();

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        User user = service.loginByNameAndPassword(userName, passWord);

        if(user != null && "2".equals(user.getUser_status())) {
            HttpSession session = request.getSession();

            session.setAttribute("admin", user);
            session.setAttribute("isLogin", "2");

            response.sendRedirect(request.getContextPath()+"/admin_index.jsp");
        }else{
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('管理员登录失败！');");
            out.write("location.href='admin_login.jsp'");
            out.write("</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
