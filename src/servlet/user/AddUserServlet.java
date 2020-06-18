package servlet.user;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), request, response);// 初始化
        String fileName = "";

        try {

            su.setAllowedFilesList("jpg,gif,jpeg,png");
            su.upload();
            String userName = su.getRequest().getParameter("userName");
            Files uploadFiles = su.getFiles();
//            fileName = uploadFiles.getFile(0).getFileName();
            fileName = uploadFiles.getFile(0).getFileExt();
            fileName = userName+"."+fileName;



            File f = new File(this.getServletContext().getRealPath("/upload/user"));
            if (!f.exists() && !f.isDirectory()) {
                f.mkdir();
            }
            uploadFiles.getFile(0).saveAs("/upload/user/"+ fileName);

        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        String userName = su.getRequest().getParameter("userName");
        String nickname = su.getRequest().getParameter("nickname");
        String passWord = su.getRequest().getParameter("passWord");
        String rePassWord = su.getRequest().getParameter("rePassWord");
        String sex = su.getRequest().getParameter("sex");
        String status = su.getRequest().getParameter("status");

        User u = new User(userName,nickname,passWord,sex,"0","0",status,fileName);
        System.out.println(u);

        UserService service = new UserServiceImpl();
        Boolean flag = service.addUser(u);
        if (flag) {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('插入成功！');");
//            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
