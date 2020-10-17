package servlet.user;

import entity.Category;
import entity.Order;
import entity.OrderList;
import entity.User;
import service.CartService;
import service.CategoryService;
import service.OrderService;
import service.UserService;
import service.impl.CartServiceImpl;
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

@WebServlet("/toUserInfoServlet")
public class ToUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");

        if (user != null) {
            UserService service = new UserServiceImpl();
            User newUser = service.findUserByUserId(user.getUser_id());

            CategoryService service1 = new CategoryServiceImpl();
            List<Category> flist = service1.findCategoryListByName("father");
            List<Category> clist = service1.findCategoryListByName("child");
            request.setAttribute("flist",flist);
            request.setAttribute("clist",clist);
            request.setAttribute("user",newUser);

            //查看该用户的各种订单数量
            OrderService service2 = new OrderServiceImpl();
            List<Order> orders = service2.findOrderByUserId(user.getUser_id());
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            for (Order o:orders) {
                if ("0".equals(o.getIs_pay()) && "0".equals(o.getIs_ship()) && "0".equals(o.getIs_receipt())) {
                    a1++;
                }
                if ("1".equals(o.getIs_pay()) && "0".equals(o.getIs_ship()) && "0".equals(o.getIs_receipt())) {
                    a2++;
                }
                if ("1".equals(o.getIs_pay()) && "1".equals(o.getIs_ship()) && "0".equals(o.getIs_receipt())) {
                    a3++;
                }
                if ("1".equals(o.getIs_pay()) && "1".equals(o.getIs_ship()) && "1".equals(o.getIs_receipt())) {
                    a4++;
                }
            }
            request.setAttribute("a1",a1);
            request.setAttribute("a2",a2);
            request.setAttribute("a3",a3);
            request.setAttribute("a4",a4);


            request.getRequestDispatcher("mygxin.jsp").forward(request, response);
        }else {
            response.sendRedirect("login.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
