package servlet.order;

import entity.Category;
import entity.Order;
import entity.User;
import service.CategoryService;
import service.OrderService;
import service.UserService;
import service.impl.CategoryServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/toMyOrderListServlet")
public class ToMyOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {
            UserService service = new UserServiceImpl();
            User newUser = service.findUserByUserId(user.getUser_id());

            CategoryService service1 = new CategoryServiceImpl();
            List<Category> flist = service1.findCategoryListByName("father");
            List<Category> clist = service1.findCategoryListByName("child");
            request.setAttribute("flist", flist);
            System.out.println(flist);
            request.setAttribute("clist", clist);
            request.setAttribute("user", newUser);

            OrderService service2 = new OrderServiceImpl();
            List<Order> orders = service2.findOrderByUserId(user.getUser_id());
            request.setAttribute("orders", orders);



            request.getRequestDispatcher("myorderlist.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
