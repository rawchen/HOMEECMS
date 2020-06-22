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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/toProductViewServlet")
public class ToProductViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数商品id
        String id = request.getParameter("id");

        //创建商品服务层对象 查询该商品后传到前台
        ProductService service2 = new ProductServiceImpl();
        Product productById = service2.findProductById(Integer.valueOf(id));
        request.setAttribute("p",productById);

        //创建分类服务层对象 查询分类列表后传到前台
        CategoryService service = new CategoryServiceImpl();
        List<Category> flist =  service.findCategoryListByName("father");
        request.setAttribute("flist", flist);
        List<Category> clist =  service.findCategoryListByName("child");
        request.setAttribute("clist", clist);

        //查询该商品的二级和一级分类
        Category c = service.findCategoryByCid(productById.getProduct_cid());
        request.setAttribute("childC",c);
        Category f = service.findCategoryByCid(c.getCategory_parentid());
        request.setAttribute("fatherC",f);

        //查询二级分类商品
        List<Product> productList = service2.findProductByCategoryCid(c.getCategory_id());
        request.setAttribute("classlist",productList);

        //查询最近访问的商品，未实现，改为了查询所有商品
        List<Product> productAllList =  service2.findAllProduct();
        request.setAttribute("lastlist",productAllList);


        //查询购物车数量


/*
        //获取最近访问

        HttpSession session = request.getSession();

        //从SSESSIOn获取一下 ids

        List<Integer> ids = (List<Integer>)session.getAttribute("ids");

        if(ids == null){
            ids = new List<Integer>();
        }

        //最多放5， 如果多出5个将第一个删除
        if(ids.size() >= 5) {
            ids.remove(0);
        }

        // 添加列表里， 但只要一份
        if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
            ids.add(Integer.parseInt(id));

        }

        session.setAttribute("ids", ids);

        ids= (List<Integer>)session.getAttribute("ids");

        if(ids!=null) {

            List<LMONKEY_PRODUCT> lastlylist = LMONKEY_PRODUCTDao.selectAllById(ids);
            request.setAttribute("lastlylist", lastlylist);
        }


        LMONKEY_PRODUCT p = null;

        if(id !=null) {
            p = LMONKEY_PRODUCTDao.selectById(Integer.parseInt(id));
            request.setAttribute("p", p);
        }


        if(p!=null) {
            int cid = p.getPRODUCT_CID();
            List<LMONKEY_PRODUCT> classlist = LMONKEY_PRODUCTDao.selectAllByCid(cid);
            request.setAttribute("classlist", classlist);

            Category cate = CategoryDao.selectById(cid);

            request.setAttribute("cate", cate);
        }*/


        request.getRequestDispatcher("productview.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
