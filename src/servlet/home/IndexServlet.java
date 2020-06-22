package servlet.home;

import entity.Category;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService service = new CategoryServiceImpl();
        List<Category> flist =  service.findCategoryListByName("father");

        request.setAttribute("flist", flist);

        List<Category> clist =  service.findCategoryListByName("child");

        request.setAttribute("clist", clist);

        ProductService service1 = new ProductServiceImpl();
        List<Product> newProductList = service1.findProductTimeSort();
        List<Product> newProductList2 = service1.findProductSalesSort();

        request.setAttribute("newProductList", newProductList);
        request.setAttribute("newProductList2", newProductList2);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
