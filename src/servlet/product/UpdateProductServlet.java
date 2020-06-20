package servlet.product;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import entity.Category;
import entity.Product;
import entity.User;
import service.CategoryService;
import service.ProductService;
import service.UserService;
import service.impl.CategoryServiceImpl;
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

@WebServlet("/manage/updateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), request, response);// 初始化
        String fileName = "";

        try {

            su.setAllowedFilesList("jpg,gif,jpeg,png");
            su.upload();
            int productId = Integer.valueOf(request.getParameter("productId"));
            Files uploadFiles = su.getFiles();
            fileName = uploadFiles.getFile(0).getFileExt();
            fileName = productId+"."+fileName;



            File f = new File(this.getServletContext().getRealPath("/upload/product"));
            if (!f.exists() && !f.isDirectory()) {
                f.mkdir();
            }
            uploadFiles.getFile(0).saveAs("/upload/product/"+ fileName);

        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        int productId = Integer.valueOf(request.getParameter("productId"));
        String productName = su.getRequest().getParameter("productName");
        String productInfo = su.getRequest().getParameter("productInfo");
        int productPrice = Integer.valueOf(su.getRequest().getParameter("productPrice"));
        int  productStock = Integer.valueOf(su.getRequest().getParameter("productStock"));
        String productFatherChildid = su.getRequest().getParameter("parentId");

        String id[] = productFatherChildid.split("-");
        int productFid = Integer.valueOf(id[0]);//f
        int productCid = Integer.valueOf(id[1]);//c

        Product p = new Product(productName,productInfo,productPrice,productStock,productFid,productCid,fileName);
        p.setProduct_id(productId);
        System.out.println(p);

        ProductService service = new ProductServiceImpl();
        service.updateProductById(p);

        PrintWriter out = response.getWriter();

        out.write("<script>");
        out.write("alert('更新成功！');");
            out.write("location.href='/HOMEECMS/productListServlet'");
        out.write("</script>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
