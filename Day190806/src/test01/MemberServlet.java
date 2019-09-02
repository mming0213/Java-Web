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
@WebServlet("/customer2")
public class MemberServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

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
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");
		
		//고객 아이디
		String id = request.getParameter("id");
		System.out.println("고객 아이디: " + id);
		String custid = request.getParameter("custid");
		
		if(command != null && command.equals("delMember"))
		{
			System.out.println("삭제할 고객번호:" + custid);
			dao.delMember(custid);	
		}
		//List list = dao.listMembers(custid2);
		List list = dao.listMembers(id);
		pw.print("<html><body>");
		pw.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		pw.print("<td>고객번호</td><td>고객이름</td><td>고객주소</td><td>주문조회</td><td>삭제</td></tr>");
		
		for(int i = 0; i <list.size(); i++) {
			
			MemberVO memberVO = (MemberVO)list.get(i);
			String cust_id = memberVO.getCust_id();
			String cust_name = memberVO.getCust_name();
			String cust_address = memberVO.getCust_address();
			
			pw.print("<tr align=center><td>" + cust_id + "</td><td>" + cust_name +"</td><td>" + cust_address + "</td><td>" + "<a href='/Day190806/customer3?command=searchMember&custid="+cust_id+"'>주문조회" + "</td><td>" + "<a href='/Day190806/customer2?command=delMember&custid="+cust_id +"&id=" +id+"'>삭제</a></td><tr>" );
		}
		
		pw.print("<br><a href='/Day190806/printinfo.html'>'고객 번호 입력창'</a><br>");
	}

}
