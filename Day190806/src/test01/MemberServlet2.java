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
 * Servlet implementation class MemberServlet4
 */
@WebServlet("/customer3")
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		String custid = request.getParameter("custid");
		System.out.println("command:" + command + ", ��ȸ�� ����ȣ:" + custid);
		
		if(command != null && command.equals("delOrder"))
		{
			String ordernum = request.getParameter("ordernum");
			String prodid = request.getParameter("prodid");
			dao.delOrder(ordernum, prodid);
		}
	
		List list = dao.listOrders(custid);
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>�ֹ���ȣ</td><td>��ǰ��</td><td>�׸����</td><td>�׸񰡰�</td><td>����</td></tr>");
	
		for(int i = 0; i <list.size(); i++) {
			MemberVO memberVO = (MemberVO)list.get(i);
			String order_num = memberVO.getOrder_num();
			String prod_name = memberVO.getProd_name();
			String quantity = memberVO.getQuantity();
			String item_price = memberVO.getItem_price();
			String prod_id = memberVO.getProd_id();
			
			//������ Ŭ���ϸ� command�� ������ �ֹ���ȣ,��ǰID, ����ȣ�� �������� �����մϴ�.
			out.print("<tr><td>" + order_num + "</td><td>" + prod_name +"</td><td>" + quantity + "</td><td>" + item_price + "</td><td>" + "<a href='/Day190806/customer3?command=delOrder&ordernum="+order_num+"&prodid="+prod_id+"&custid="+custid+"'>����</a></td></tr>");
			
		}
		out.print("</table></body></html>");
		
	}

}
