package servlet.user;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import entity.Product;
import entity.User;
import service.ProductService;
import service.UserService;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateUserPhotoServlet")
public class UpdateUserPhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {

            SmartUpload su = new SmartUpload();
            su.initialize(this.getServletConfig(), request, response);// 初始化
            String fileName = "";
            int userId = user.getUser_id();

            try {

                su.setAllowedFilesList("jpg,gif,jpeg,png");
                su.upload();

                Files uploadFiles = su.getFiles();
                fileName = uploadFiles.getFile(0).getFileExt();
                fileName = userId + "." + fileName;

                File f = new File(this.getServletContext().getRealPath("/upload/user"));
                if (!f.exists() && !f.isDirectory()) {
                    f.mkdir();
                }
                uploadFiles.getFile(0).saveAs("/upload/user/" + fileName);

            } catch (SmartUploadException e) {
                e.printStackTrace();
            }

            UserService service = new UserServiceImpl();
            service.updatePhotoById(userId,fileName);

            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('更新成功！');");
            out.write("location.href='toMyInfoServlet'");
            out.write("</script>");
            out.close();
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
