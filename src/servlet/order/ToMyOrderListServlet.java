package servlet.order;

import entity.Category;
import entity.Order;
import entity.OrderList;
import entity.User;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            ProductService service3 = new ProductServiceImpl();


            request.getRequestDispatcher("myorderlist.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
