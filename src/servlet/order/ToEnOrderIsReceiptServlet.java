package servlet.order;

import entity.User;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/toEnOrderIsReceiptServlet")
public class ToEnOrderIsReceiptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");
        if (user != null) {

            String oid = request.getParameter("oid");
            System.out.println(oid);

            OrderService service = new OrderServiceImpl();
            service.updateOrderIsReceipt(oid);

            request.getRequestDispatcher("toMyOrderListServlet").forward(request,response);
        }else {
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
