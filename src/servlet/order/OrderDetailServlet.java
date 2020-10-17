package servlet.order;

import entity.Address;
import entity.Category;
import entity.Order;
import entity.User;
import service.AddressService;
import service.CategoryService;
import service.OrderService;
import service.UserService;
import service.impl.AddressServiceImpl;
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

@WebServlet("/orderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        UserService service = new UserServiceImpl();
        User newUser = service.findUserByUserId(user.getUser_id());
        request.setAttribute("user",newUser);

        CategoryService service1 = new CategoryServiceImpl();
        List<Category> flist = service1.findCategoryListByName("father");
        List<Category> clist = service1.findCategoryListByName("child");
        request.setAttribute("flist",flist);
        request.setAttribute("clist",clist);

        String oid = request.getParameter("oid");
        OrderService service2 = new OrderServiceImpl();
        Order order = service2.findOrderById(oid);

        request.setAttribute("order",order);

        AddressService service3 = new AddressServiceImpl();
        Address address = service3.findAddressByAddressId(order.getAddress_id());

        request.setAttribute("address",address);


        request.getRequestDispatcher("orderxq.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
