package servlet.comment;

import entity.Comment;
import entity.User;
import service.CommentService;
import service.UserService;
import service.impl.CommentServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/addCommentServlet")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {

            int userId = user.getUser_id();
            String commentInfo = request.getParameter("commentInfo");

            Comment comment = new Comment(userId,8,new Date(),commentInfo);

            CommentService service = new CommentServiceImpl();
            service.addComment(comment);

            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('评价成功！');");
            out.write("location.href='toMyCommentListServlet'");
            out.write("</script>");
            out.close();
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
