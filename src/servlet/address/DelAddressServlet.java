package servlet.address;

import entity.Address;
import entity.Category;
import entity.User;
import service.AddressService;
import service.CategoryService;
import service.UserService;
import service.impl.AddressServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/delAddressServlet")
public class DelAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");

        if (user != null) {
            AddressService service2 = new AddressServiceImpl();
            String aid = request.getParameter("aid");
            int aid2 = Integer.valueOf(aid);
            service2.delAddressById(aid2);

            //查询地址列表
            List<Address> addresses = service2.findAddressByUserId(user.getUser_id());
            request.setAttribute("addresses",addresses);

            UserService service = new UserServiceImpl();
            User newUser = service.findUserByUserId(user.getUser_id());

            CategoryService service1 = new CategoryServiceImpl();
            List<Category> flist = service1.findCategoryListByName("father");
            List<Category> clist = service1.findCategoryListByName("child");
            request.setAttribute("flist",flist);
            request.setAttribute("clist",clist);
            request.setAttribute("user",newUser);


            request.getRequestDispatcher("address.jsp").forward(request, response);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
