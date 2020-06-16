package servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import service.CATEGORYDao;

/**
 * Servlet implementation class ToCateAdd
 */
@WebServlet("/manage/admin_tocateadd")
public class ToCateAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> catelist = CATEGORYDao.selectAll();
		
		request.setAttribute("catelist", catelist);
		
		request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);
	}



}
