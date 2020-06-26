package servlet.product;

import entity.Category;
import entity.PageBean;
import entity.Product;

import service.CategoryService;
import service.ProductService;

import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }




        ProductService service = new ProductServiceImpl();

        PageBean<Product> pb = service.findProductByPage(currentPage,rows);
        request.setAttribute("pb",pb );


//        List<Product> plist = service.findAllProduct();
//
//        request.setAttribute("plist", plist);

        CategoryService service2 = new CategoryServiceImpl();
        List<Category> f = service2.findCategoryListByName("father");
        List<Category> c = service2.findCategoryListByName("child");
        request.setAttribute("flist", f);
        request.setAttribute("clist", c);

        request.getRequestDispatcher("manage/admin_product.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
