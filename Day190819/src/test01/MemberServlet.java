//package test01;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class OrderServlet
// */
//@WebServlet("/log")
//public class MemberServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		doHandle(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doHandle(request, response);
//	}
//	
//	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		MemberDAO dao = new MemberDAO();
//		MemberBean vo = new MemberBean();
//		List membersList;
//		String _id = request.getParameter("id");
//		String command = request.getParameter("command");
//		System.out.println("_id:"+ _id + "command 확인:" + command);
//		
//		if(command != null && command.equals("createMember"))
//		{	
//			System.out.println("=======MemberServlet-createMember(command)======");
//			String member_id = request.getParameter("id");
//			String name = request.getParameter("name");
//			String pw = request.getParameter("pw");
//			String check = request.getParameter("check");
//			
//			vo.setMember_id(member_id);
//			vo.setName(name);
//			vo.setPassword(pw);
//			vo.setCheck(check);
//			
//			dao.addMember(vo);		
//		}
//		
////		else if(command != null && command.equals("addUpdate"))
////		{	
////			System.out.println("고객 추가 되는지");
////			String id = request.getParameter("id");
////			String name = request.getParameter("name");
////			String address = request.getParameter("address");
////			String state = request.getParameter("state");
////			String zip = request.getParameter("zip");
////			String country = request.getParameter("country");
////			String contact = request.getParameter("contact");
////			String email = request.getParameter("email");
////			
////			vo.setId(id);
////			vo.setName(name);
////			vo.setAddress(address);
////			vo.setState(state);
////			vo.setZip(zip);
////			vo.setCountry(country);
////			vo.setContact(contact);
////			vo.setEmail(email);
////			
////			dao.addMember(vo);
////			_id = null;			
////		}
////		else if(command != null && command.equals("modUpdate")) {
////			System.out.println("수정 되는지");
////			String changid = request.getParameter("change_id");
////			String id = request.getParameter("id");
////			String name = request.getParameter("name");
////			String address = request.getParameter("address");
////			String state = request.getParameter("state");
////			String zip = request.getParameter("zip");
////			String country = request.getParameter("country");
////			String contact = request.getParameter("contact");
////			String email = request.getParameter("email");
////			
////			System.out.println("수정한 값확인 :" +changid + "/"+ id +"/"+ name  +"/"+ address);
////			
////			vo.setId(id);
////			vo.setName(name);
////			vo.setAddress(address);
////			vo.setState(state);
////			vo.setZip(zip);
////			vo.setCountry(country);
////			vo.setContact(contact);
////			vo.setEmail(email);
////			
////			dao.editMember(changid, vo);
////			
////			_id = null;
////		}
////		else if(command != null && command.equals("modSearch")) {
////			//String p_mod_id = request.getParameter("change_id");
////			System.out.println("=======컬럼 아디:==========" );
////			vo.setId(_id);
////			
////			System.out.println("=====MemberServlet(command:modSearch)=======");
////			request.setAttribute("command", "modSearch");
////			request.setAttribute("vo", vo);
////			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
////			dispatch.forward(request, response);
////			
////			return;
////		}
////		else if(command != null && command.equals("addSearch")) {
////			request.setAttribute("command", "addSearch");
////			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
////			dispatch.forward(request, response);
////			
////			return;
////		}
//		
////		System.out.println("=======MemberServlet===="+_id);
////		vo.setId(_id);
////		
////		membersList = dao.listMembers(vo);
////		request.setAttribute("membersList", membersList);
////		RequestDispatcher dispatch = request.getRequestDispatcher("member2.jsp"); // 여기는 상대주소로 적음
////		dispatch.forward(request, response);
//		
//
//		
//		
//	}
//
//}
