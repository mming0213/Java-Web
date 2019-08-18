package sec01.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2"   //urlPatterns를 이용해 매핑 이름을 여러개 설정할 수 있음.
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")    //@WebInitParam을 이용해 여러개의 매개변수를 설정할 수 있음.
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");  //설정한 매개변수의 name으로 값을 가져옴.
		
		out.println("<html><body>");
		out.println("<table><tr>");
		out.println("<td>email: </td><td>" + email+ "</td></tr>");
		out.println("<td>휴대전화: </td><td>" + tel+ "</td>");
		out.println("</tr></table></body></html>");
			
	
	}

}
