package servlet.category;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/updateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String categoryId = request.getParameter("categoryId");
        int categoryId2 = Integer.valueOf(categoryId);
        String categoryName = request.getParameter("categoryName");
        CategoryService service = new CategoryServiceImpl();
        service.updateCategoryName(categoryName,categoryId2);

        PrintWriter out = response.getWriter();

        out.write("<script>");
        out.write("alert('更新成功！');");
        out.write("location.href='/HOMEECMS/categoryListServlet'");
        out.write("</script>");
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
