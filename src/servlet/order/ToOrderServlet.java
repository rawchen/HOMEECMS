package servlet.order;

import entity.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/toOrderServlet")
public class ToOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {
            CategoryService service1 = new CategoryServiceImpl();
            List<Category> flist = service1.findCategoryListByName("father");
            List<Category> clist = service1.findCategoryListByName("child");
            request.setAttribute("flist",flist);
            request.setAttribute("clist",clist);

            AddressService service = new AddressServiceImpl();
            List<Address> addresses = service.findAddressByUserId(user.getUser_id());
            request.setAttribute("address",addresses);

            //计算商品价格
            String uid = request.getParameter("uid");
            String pid = request.getParameter("pid");
            String count = request.getParameter("count");

            ProductService service2 = new ProductServiceImpl();
            Product p = service2.findProductById(Integer.valueOf(pid));
            int price = p.getProduct_price();
            int totalPrice = price*Integer.valueOf(count);

            request.setAttribute("price",price);
            request.setAttribute("count",count);
            request.setAttribute("product",p);
            request.setAttribute("totalPrice",totalPrice);

            //查询购物车数量


            String cartCount = "0";
            CartService service3 = new CartServiceImpl();
            if (user != null) {
                cartCount = String.valueOf(service3.findCartCountByUserId(user.getUser_id()));
            }else {
                cartCount = "?";
            }
            request.setAttribute("cartCount",cartCount);

            //添加此订单为待支付订单
            Order order = new Order(System.currentTimeMillis() +""+ user.getUser_id(),user.getUser_id(),totalPrice,new Date(),"0","0","0");
            System.out.println(order);
            OrderService service4 = new OrderServiceImpl();
            service4.addOrder(order);

            request.getRequestDispatcher("order.jsp").forward(request, response);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
