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

@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        UserService service = new UserServiceImpl();

        String userName = request.getParameter("userName").trim();
        String userPassword = request.getParameter("userPassword").trim();
        String enUserPassword = request.getParameter("enUserPassword".trim());
        String verifycode = request.getParameter("verifycode".trim());

        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证一次性
        if (!verifycode.equalsIgnoreCase(checkcode_server)){
            request.setAttribute("msg","验证码错误");
            request.setAttribute("userName",userName);
            request.setAttribute("userPassword",userPassword);
            request.setAttribute("enUserPassword",enUserPassword);

            request.getRequestDispatcher("reg.jsp").forward(request,response);
            return;
        }else {
            if (!userPassword.equals(enUserPassword)) {
                request.setAttribute("msg","密码确认错误");
                request.setAttribute("userName",userName);
                request.setAttribute("userPassword",userPassword);
                request.setAttribute("enUserPassword",enUserPassword);
                request.getRequestDispatcher("reg.jsp").forward(request,response);
                return;
            }else {
                User user = service.findUserByUserName(userName);

                if (user != null) {
                    request.setAttribute("msg", "用户已存在");
                    request.setAttribute("userName", userName);
                    request.setAttribute("userPassword", userPassword);
                    request.setAttribute("enUserPassword", enUserPassword);
                    request.getRequestDispatcher("reg.jsp").forward(request, response);
                    return;
                } else {
                    User u = new User(userName,"无昵称哦",userPassword,null,"0","0","1","default_0.jpg");
                    service.addUser(u);

                    request.setAttribute("msg", "注册成功！");
                    request.getRequestDispatcher("reg.jsp").forward(request,response);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
