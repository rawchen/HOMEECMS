package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLogin
 */
@WebFilter("/adminTest/*")
public class AdminLogin implements Filter {

    public AdminLogin() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");
		String url=req.getRequestURI();

		if(url.indexOf(".css")>0) {
			chain.doFilter(req, resp);
			return;
		}else {
			response.setContentType("text/html; charset=UTF-8");
		}


		
		HttpSession session = req.getSession();
		
		String flag = (String)session.getAttribute("isLogin");
		
		String request_uri = req.getRequestURI();
		String ctxPath= req.getContextPath();
		String uri= request_uri.substring(ctxPath.length());
		
	//	System.out.println(request_uri+"##"+ctxPath+"##"+uri+"##"+flag);
		
		if(uri.contains("admin_")){
			if(flag !=null && flag.equals("2")) {
				chain.doFilter(req, resp);
			}else{
				PrintWriter out = resp.getWriter();
				out.write("<script>");
				out.write("alert('请先登录！');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
		}else{
			chain.doFilter(req, resp);	
		}
		
		return;
		
		 //不通过则直接return
		// pass the request along the filter chain
	//	chain.doFilter(req, resp); // 通过则使用这条语句
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
