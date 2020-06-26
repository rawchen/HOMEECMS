package servlet.order;

import entity.Order;
import entity.PageBean;
import entity.User;
import service.OrderService;
import service.UserService;
import service.impl.OrderServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toAllOrderListServlet")
public class ToAllOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service = new OrderServiceImpl();
//        List<Order> orders = service.findAllOrder();
//        request.setAttribute("orders",orders);

        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        OrderService service2 = new OrderServiceImpl();
        PageBean<Order> pb = service2.findOrderByPage(currentPage,rows);
        request.setAttribute("pb",pb );

        request.getRequestDispatcher("manage/admin_order.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
