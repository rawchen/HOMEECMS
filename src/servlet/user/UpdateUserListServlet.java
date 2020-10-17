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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateUserListServlet")
public class UpdateUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), request, response);// 初始化
        String fileName = "";

        try {

            su.setAllowedFilesList("jpg,gif,jpeg,png");
            su.upload();
            int UserId = Integer.valueOf(request.getParameter("userId"));
            Files uploadFiles = su.getFiles();
            fileName = uploadFiles.getFile(0).getFileExt();
            String fileNameExt = uploadFiles.getFile(0).getFileExt();
            if("".equals(fileName)) {
                System.out.println("1kong");
                UserService service = new UserServiceImpl();
                User u = service.findUserByUserId(UserId);
                fileName = u.getUser_photo();
            }else {
                System.out.println("no kong");
                fileName =  UserId+"."+fileNameExt;
                File f = new File(this.getServletContext().getRealPath("/upload/user"));
                if (!f.exists() && !f.isDirectory()) {
                    f.mkdir();
                }
                uploadFiles.getFile(0).saveAs("/upload/user/"+ fileName);
            }



        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        int userId = Integer.valueOf(request.getParameter("userId"));
        String nickname = su.getRequest().getParameter("nickName");
        String username = su.getRequest().getParameter("name");
        String passWord = su.getRequest().getParameter("passWord");
        String sex = su.getRequest().getParameter("sex");
        String vip="0";
        String viptime="0";
        String status="1";
        User user = new User(username,nickname,passWord,sex,vip,viptime,status,fileName);
        user.setUser_id(userId);
        System.out.println(user);

        UserService service = new UserServiceImpl();
        service.updateUserById(user);

        PrintWriter out = response.getWriter();

        out.write("<script>");
        out.write("alert('更新成功！');");
        out.write("location.href='/HOMEECMS/userListServlet'");
        out.write("</script>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
