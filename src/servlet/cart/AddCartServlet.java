package servlet.cart;

import entity.Cart;
import entity.Product;
import entity.User;
import service.CartService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {
            //获取用户id
            //获取商品id
            //获取数量
            String pid = request.getParameter("pid");
            int pid2 = Integer.valueOf(pid);
            String count = request.getParameter("count");
            int count2 = Integer.valueOf(count);

            ProductService service = new ProductServiceImpl();
            Product p = service.findProductById(pid2);

            Cart cart = new Cart(pid2,user.getUser_id(),p.getProduct_name(),p.getProduct_price(),count2,"0",p.getProduct_photo());

            CartService service2 = new CartServiceImpl();
            service2.addCart(cart);


            request.getRequestDispatcher("toCartServlet").forward(request, response);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
