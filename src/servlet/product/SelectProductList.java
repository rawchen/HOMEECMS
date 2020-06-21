package servlet.product;

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
import java.util.List;

@WebServlet("/selectProductList")
public class SelectProductList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        ProductService service = new ProductServiceImpl();
        List<Product> list = service.findProductByCategoryCid(Integer.valueOf(cid));

        request.setAttribute("productList",list);

        CategoryService service2 = new CategoryServiceImpl();
        Category c = service2.findCategoryByCid(Integer.valueOf(cid));
        System.out.println(c.getCategory_name());
        request.setAttribute("childC",c);
        Category f = service2.findCategoryByCid(c.getCategory_parentid());
        System.out.println(f.getCategory_name());
        request.setAttribute("fatherC",f);

        List<Category> flist =  service2.findCategoryListByName("father");

        request.setAttribute("flist", flist);

        List<Category> clist =  service2.findCategoryListByName("child");

        request.setAttribute("clist", clist);
        request.getRequestDispatcher("productlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
