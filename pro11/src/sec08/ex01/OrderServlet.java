package sec08.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
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
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		System.out.println("=======OrderServlet====");
		
		String _originnum = request.getParameter("order_num");
		String command = request.getParameter("command");
		
		
		
		if(command != null && command.equals("editMember"))
		{	
			System.out.println("수정 되는지");
			
			String _ordernum = request.getParameter("order_num");
			String _orderitem = request.getParameter("order_item");
			String _prodid = request.getParameter("prod_id");
			String _quantity = request.getParameter("quantity");
			String _itemprice = request.getParameter("item_price");
			String _columnid = request.getParameter("columnid");
			String _columnitem = request.getParameter("columnitem");
			
			System.out.println("-------------------");
			System.out.println("3.vendor/editmemver/"+ _columnid+"/" +_columnitem +"/"+_ordernum + _orderitem + _prodid + _quantity + _itemprice);
			
			vo.setOrder_num(_ordernum);
			vo.setOrder_item(_orderitem);
			vo.setProd_id(_prodid);
			vo.setQuantity(_quantity);
			vo.setItem_price(_itemprice);
			
			dao.editMember(_columnid,_columnitem, vo);
			_originnum = null;
			

//			
//			dao.editMember(_originId, _ordernum, _orderitem, _prodid, _quantity, _itemprice);
		}
		
		System.out.println("=======OrderServlet====");
		vo.setOrder_num(_originnum);
		
		List membersList = dao.listMembers(vo);
		request.setAttribute("membersList", membersList);
		RequestDispatcher dispatch = request.getRequestDispatcher("/test01/order.jsp"); // 여기는 상대주소로 적음
		dispatch.forward(request, response);
		
		
		
//		System.out.println("=========orderSevlet==========");
//		
//		vo.setOrder_num(_ordernum);
//
//		List membersList = dao.listMembers(vo);
//		request.setAttribute("membersList", membersList);
//		RequestDispatcher dispatch = request.getRequestDispatcher("order.jsp");
//		dispatch.forward(request, response);
//		
//		if(command != null && command.equals("editMember"))
//		{
//			System.out.println("수정 되는지");
//			
//			String _originid = request.getParameter("columnid");
//			System.out.println("컬럼의 해당 아이디:" + _originid);
//
//			String _ordernum = request.getParameter("order_num");
//			String _orderitem = request.getParameter("order_item");
//			String _prodid = request.getParameter("prod_id");
//			String _quantity = request.getParameter("quantity");
//			String _itemprice = request.getParameter("item_price");
//
//			
//			System.out.println("-------------------");
//			MemberVO memberVO = new MemberVO();
//			
//			memberVO.setOrder_num(_ordernum);
//			memberVO.setOrder_item(_orderitem);
//			memberVO.setProd_id(_prodid);
//			memberVO.setQuantity(_quantity);
//			memberVO.setItem_price(_itemprice);
//			List membersList = dao.listMembers(memberVO);
//			
//			request.setAttribute("membersList", membersList);
//			RequestDispatcher dispatch = request.getRequestDispatcher("/test01/editorder.jsp");
//			dispatch.forward(request, response);
//			dao.editMember(_originid, memberVO);
//		}
		

		
		
	}

}
