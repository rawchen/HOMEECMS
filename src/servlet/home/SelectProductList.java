package servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.CATEGORY;
import entity.PRODUCT;
import service.CATEGORYDao;
import service.PRODUCTDao;

/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> flist =  CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<CATEGORY> clist =  CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		int id=0;
		ArrayList<PRODUCT> list = null;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list = PRODUCTDao.selectAllByFid(id);
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list = PRODUCTDao.selectAllByCid(id);
		}
		
		request.setAttribute("title", CATEGORYDao.selectById(id).getCATE_NAME());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}



}
