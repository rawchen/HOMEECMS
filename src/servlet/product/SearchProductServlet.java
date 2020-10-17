package servlet.product;

import entity.Category;
import entity.Product;
import entity.User;
import service.CartService;
import service.CategoryService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchProductServlet")
public class SearchProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String key = request.getParameter("key");
        ProductService service = new ProductServiceImpl();
        List<Product> list = service.findProductListByKey(key);
        request.setAttribute("productList",list);


        //查询购物车数量
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");

        String cartCount = "0";
        CartService service1 = new CartServiceImpl();
        if (user != null) {
            cartCount = String.valueOf(service1.findCartCountByUserId(user.getUser_id()));
        }else {
            cartCount = "?";
        }
        request.setAttribute("cartCount",cartCount);

        CategoryService service2 = new CategoryServiceImpl();
        List<Category> flist =  service2.findCategoryListByName("father");
        request.setAttribute("flist", flist);
        List<Category> clist =  service2.findCategoryListByName("child");
        request.setAttribute("clist", clist);


        //没实现分类添加图片
        request.setAttribute("link", "img/banner1.jpg");


        request.getRequestDispatcher("searchproductlist.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
