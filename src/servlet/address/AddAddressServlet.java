package servlet.address;

import entity.Address;
import entity.User;
import service.AddressService;
import service.UserService;
import service.impl.AddressServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");

        if (user != null) {

            UserService service = new UserServiceImpl();
            User newUser = service.findUserByUserId(user.getUser_id());
            request.setAttribute("user",newUser);

            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            System.out.println(name+" "+phone+ " "+address);

            AddressService service1 = new AddressServiceImpl();
            Address a = new Address(user.getUser_id(),name,phone,address);
            service1.addAddress(a);

            //查询地址列表
            List<Address> addresses = service1.findAddressByUserId(user.getUser_id());
            request.setAttribute("addresses",addresses);

            response.sendRedirect(request.getContextPath()+"/toMyAddressListServlet");
        }else {
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
