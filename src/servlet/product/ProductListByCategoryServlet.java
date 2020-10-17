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

@WebServlet("/productListByCategoryServlet")
public class ProductListByCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parentId = request.getParameter("parentId");

        String[] id = parentId.split("-");
        int productFid = Integer.valueOf(id[0]);//f
        int productCid = Integer.valueOf(id[1]);//c

        System.out.println(productCid);
        ProductService service = new ProductServiceImpl();

        List<Product> plist = service.findProductByCategoryCid(productCid);

        request.setAttribute("plist", plist);

        CategoryService service2 = new CategoryServiceImpl();
        List<Category> f = service2.findCategoryListByName("father");
        List<Category> c = service2.findCategoryListByName("child");
        request.setAttribute("flist", f);
        request.setAttribute("clist", c);

        request.getRequestDispatcher("admin_product.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
