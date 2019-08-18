package test01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/customer")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		System.out.println("MemberServlet, id:" + id + ",command:" + command);
		List list = dao.listMembers(id);
		
		if(command != null && command.equals("customer")) {
			
			pw.print("<html><body>");
			pw.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
			pw.print("<td>����ȣ</td><td>����</td><td>�ֹ���ȣ</td><td>�ֹ���ǰ��ȣ</td><td>�ֹ���ǰ��</td></tr>");
			
			for(int i = 0; i <list.size(); i++) {
				
				MemberVO memberVO = (MemberVO)list.get(i);
				String cust_id = memberVO.getCust_id();
				String cust_name = memberVO.getCust_name();
				String order_num = memberVO.getOrder_num();
				String prod_id = memberVO.getProd_id();
				String prod_name = memberVO.getProd_name();
				
				pw.print("<tr align=center bgcolor='#FFFF00'><td>" + cust_id + "</td><td>" + cust_name +"</td><td>" + order_num + "</td><td>" + prod_id + "</td><td>" + prod_name + "</td><tr>" );
			}
			
			pw.print("<br><a href='/Day190805/customer'>'�� ��ȣ �Է�â'</a><br>");
			return;
		}
			
		pw.print("<html><title>�� ���� �ý���</title>");
		pw.print("<font size=5>�� ���� �ý���</font><br>");
		pw.print("<form name='frmCalc', method='get' action='/Day190805/customer' />");
		pw.print("�� ��ȣ:  <input type = 'text' name ='id' size = 10  /> ");
		pw.print("<input type = 'hidden' name = 'command' value = 'customer'  />");
		pw.println("<input type = 'submit' value = '�ֹ���ȣ ��ȸ'  />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
