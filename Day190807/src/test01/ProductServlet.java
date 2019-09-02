package test01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/prod")
public class ProductServlet extends HttpServlet {
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
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");
		String origin_id = request.getParameter("prod_id");
		String origin_vid = request.getParameter("vend_id");
		System.out.println("ID: " + origin_id +", VEND ID: "+origin_vid);
		if(command != null && command.equals("delMember"))
		{
			String delid = request.getParameter("prodid");
			System.out.println("제품번호확인" + delid);
			dao.delMember(delid);
		}
		else if(command != null && command.equals("addMember"))
		{
			System.out.println("제품 추가 되는지");
			String _id = request.getParameter("id");
			String _name = request.getParameter("name");
			String _price = request.getParameter("price");
			String _prod_desc = request.getParameter("desc");
			String _vend_id = request.getParameter("vend");

			MemberVO vo = new MemberVO();
			vo.setProd_id(_id);
			vo.setProd_name(_name);
			vo.setProd_price(_price);
			vo.setProd_desc(_prod_desc);
			vo.setVend_id(_vend_id);
			
			dao.addMember(vo);
//			id = null;
//			vid = null;
		}
		
		List list = dao.listMembers(origin_id, origin_vid);
		pw.print("<html><body>");
		pw.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		//pw.print("<td>고객번호</td><td>고객명</td><td>주문번호</td><td>주문상품번호</td><td>주문상품명</td><td>주문조회</td><td>삭제</td></tr>");
		pw.print("<td>제품번호</td><td>제품명</td><td>제품가격</td><td>제품설명</td><td>공급업체명</td><td>삭제</td></tr>");
		
		for(int i = 0; i <list.size(); i++) {
			
			MemberVO memberVO = (MemberVO)list.get(i);
			String prod_id = memberVO.getProd_id();
			String prod_name = memberVO.getProd_name();
			String prod_price = memberVO.getProd_price();
			String prod_desc = memberVO.getProd_desc();
			String vend_name = memberVO.getVend_name();
			
			pw.print("<tr><td>" + prod_id + "</td><td>" + prod_name +"</td><td>" + prod_price + "</td><td>" + prod_desc +"</td><td>" + vend_name +"</td><td>"+ "<a href='/Day190807/prod?command=delMember&prodid="+prod_id+"&vendid="+origin_vid+"&prodid=" + origin_id+"'>삭제</a></td><tr>" ); 
		}
		
		pw.print("<br><a href='/Day190807/productinfo.html'>'고객 번호 입력창'</a><br>");
	}
}
