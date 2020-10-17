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
import java.io.PrintWriter;

@WebServlet("/addCategoryFatherServlet")
public class AddCategoryFatherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String fatherName = request.getParameter("fatherName");

        System.out.println("fatherName"+fatherName);

        Category category = new Category();
        category.setCategory_parentid(0);
        category.setCategory_name(fatherName);

        CategoryService service = new CategoryServiceImpl();
        service.addCategory(category);

        PrintWriter out = response.getWriter();
        out.write("<script>");
        out.write("alert('插入分类成功！');");
        out.write("location.href='/HOMEECMS/categoryListServlet'");
        out.write("</script>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
