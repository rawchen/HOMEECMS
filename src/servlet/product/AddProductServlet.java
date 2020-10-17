package servlet.product;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import entity.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String fileName = "";

        SmartUpload su= new SmartUpload();
        su.initialize(this.getServletConfig(), request, response);
        try {
            su.setAllowedFilesList("jpg,gif,jpeg,png");
            su.upload();
            String id = String.valueOf(System.currentTimeMillis());
            Files uploadFiles = su.getFiles();
            fileName = uploadFiles.getFile(0).getFileExt();
            fileName = id+"."+fileName;

            File f = new File(this.getServletContext().getRealPath("/upload/product"));
            if (!f.exists() && !f.isDirectory()) {
                f.mkdir();
            }
            uploadFiles.getFile(0).saveAs("/upload/product/"+ fileName);

        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        String productName = su.getRequest().getParameter("productName");
        String productInfo = su.getRequest().getParameter("productInfo");
        int productPrice = Integer.valueOf(su.getRequest().getParameter("productPrice"));
        int  productStock = Integer.valueOf(su.getRequest().getParameter("productStock"));
        String productFatherChildid = su.getRequest().getParameter("parentId");

        String[] ids = productFatherChildid.split("-");
        int productFid = Integer.valueOf(ids[0]);//f
        int productCid = Integer.valueOf(ids[1]);//c

        Product p = new Product(productName,productInfo,productPrice,productStock,productFid,productCid,fileName,new Date());
        ProductService service = new ProductServiceImpl();
        service.addProduct(p);

        PrintWriter out = response.getWriter();

        out.write("<script>");
        out.write("alert('增加成功！');");
        out.write("location.href='/HOMEECMS/productListServlet'");
        out.write("</script>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
