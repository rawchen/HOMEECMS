package servlet.category;

import entity.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/toUpdateCategoryServlet")
public class ToUpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String cid = request.getParameter("cid");
        int cid2 = Integer.valueOf(cid);
        System.out.println(cid);
        //原分类名称
        CategoryService service = new CategoryServiceImpl();
        Category c = service.findCategoryByCid(cid2);
        request.setAttribute("c",c);

        request.getRequestDispatcher("admin_catemodify.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
