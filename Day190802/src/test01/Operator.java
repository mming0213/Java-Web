package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Operator
 */
@WebServlet("/operator")
public class Operator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		String operator = request.getParameter("operator");
		
		String result = calculate(Integer.parseInt(su1),Integer.parseInt(su2), operator);
		pw.print("<html><font size=10>계산 결과</font><br>");
		pw.print("<html><font size = 10>" + result + "</font><br>");
		pw.print("<a href='/Day190802/operator.html'>계산기</a>");
		return;
		
	}
	
	private static String calculate(int su1, int su2, String operator) {
		String result = null;
		if(operator.equals("+")) {
			result = String.format("%d", su1 + su2);
		}
		else if(operator.equals("-")) {
			result = String.format("%d", su1 - su2);
		}
		else if(operator.equals("*")) {
			result = String.format("%d", su1 * su2);
		}
		else if(operator.equals("/")) {
			result = String.format("%d", su1 / su2);
		}
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
