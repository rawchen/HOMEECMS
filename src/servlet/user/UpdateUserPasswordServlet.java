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

@WebServlet("/updateUserPasswordServlet")
public class UpdateUserPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {
            String p = request.getParameter("password");
            String enp = request.getParameter("enpassword");
            if (p.equals(enp)) {
                UserService service = new UserServiceImpl();
                service.updatePasswordById(user.getUser_id(),p);

                request.getRequestDispatcher("toMyInfoServlet").forward(request,response);

            }else {
                PrintWriter out = response.getWriter();

                out.write("<script>");
                out.write("alert('密码确认失败！');");
                out.write("location.href='toMyInfoServlet'");
                out.write("</script>");
                out.close();
            }


        }else {
            response.sendRedirect("login.jsp");
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
