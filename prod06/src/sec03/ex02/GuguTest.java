package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguTest
 */
@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));
		out.print("<table border=1 witdth=800 align=center>");
		out.print("<tr align=center bgcolor='#FFFF66'>");
		out.print("<td colspan=4>" + dan + " 단 출력 </td>");
		out.print("</tr>");
//		
//		for(int i = 1; i < 10; i++) {
//			out.print("<tr align = center>");
//			out.print("<td width = 400>");
//			out.print(dan + "* " + i);
//			out.print("</td>");
//			out.print("<td width=400>");
//			out.print(i*dan);
//			out.print("</td>");
//			out.print("</tr>");
//		}
//		out.print("</table>");
		
		
		for(int i = 1; i <10; i++) {
			if(i%2 == 0)
			{
				out.print("<tr align=center bgcolor='#ACFA58'> ");
			}
			else {
				out.print("<tr align=center bgcolor='#81BEF7'> ");
			}
			out.print("<td width=200>");
			out.print("<input type='radio' />" + i);
			out.print("</td>");
			out.print("<td width=200> ");
			out.print("<input type='checkbox' />" + i);
			out.print("</td>");
			
			out.print("<td width=700>");
			out.print(dan + "  * " + i );
			out.print("</td>");
			out.print("<td width=400>");
			out.print(i*dan);
			out.print("</td>");
			out.print("</tr>");
			
		}
		out.print("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}


}
