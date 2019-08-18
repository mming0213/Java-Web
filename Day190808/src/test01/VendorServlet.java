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
 * Servlet implementation class VendorServlet
 */
@WebServlet("/vendor")
public class VendorServlet extends HttpServlet {
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

		String vid = request.getParameter("vend_id");
		
		if(command != null && command.equals("delMember"))
		{
			
			String delid = request.getParameter("vendid");
			System.out.println("공급업체번호확인" + delid);
			dao.delMember(delid);
			
		}
		else if(command != null && command.equals("editMember"))
		{
			System.out.println("공급업체 수정 되는지");
			
			String originid = request.getParameter("originid");
			System.out.println("컬럼의 해당 아이디:" + originid);
			
			String _vendid = request.getParameter("vend_id");
			String _vendname = request.getParameter("vend_name");
			String _vendaddress = request.getParameter("vend_address");
			String _vendcity = request.getParameter("vend_city");
			String _vendstate = request.getParameter("vend_state");
			String _vendzip = request.getParameter("vend_zip");
			String _vendcountry = request.getParameter("vend_country");
			
			System.out.println("-------------------");
			System.out.println("3.vendor/editmemver/"+ _vendid + _vendname + _vendaddress + _vendcity + _vendstate + _vendzip + _vendcountry );
			MemberVO vo = new MemberVO();
			
			vo.setVend_id(_vendid);
			vo.setVend_name(_vendname);
			vo.setVend_address(_vendaddress);
			vo.setVend_city(_vendcity);
			vo.setVend_state(_vendstate);
			vo.setVend_zip(_vendzip);
			vo.setVend_country(_vendcountry);
			
			dao.editMember(originid, vo);
			vid = request.getParameter("vend_id");
			vid = null;
			

		}
	
		List list = dao.listMembers(vid);
		pw.print("<html><body>");
		pw.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		pw.print("<td>공급업체번호</td><td>공급업체이름</td><td>공급업체주소</td><td>공급업체 시</td><td>공급업체 주</td><td>공급업체 우편번호</td><td>공급업체 국가</td><td>수정</td><td>삭제</td></tr>");
		
		for(int i = 0; i <list.size(); i++) {
			MemberVO memberVO = (MemberVO)list.get(i);
			String vend_id = memberVO.getVend_id();
			String vend_name = memberVO.getVend_name();
			String vend_address = memberVO.getVend_address();
			String vend_city = memberVO.getVend_city();
			String vend_state = memberVO.getVend_state();
			String vend_zip = memberVO.getVend_zip();
			String vend_country = memberVO.getVend_country();
			System.out.println(vend_id + vend_name + vend_address);
			
			
			pw.print("<tr><td>" + vend_id + "</td><td>" + vend_name +"</td><td>" + vend_address + "</td><td>" + vend_city +"</td><td>" + vend_state +"</td><td>"+ vend_zip +"</td><td>"+ vend_country +"</td><td>"+ "<a href='/pro09/edit?command=editMember&editid="+vend_id+"&searchid=" +vend_id+"&editname=" +vend_name+"&editaddress=" + vend_address + "&editcity=" +vend_city + "&editstate="+vend_state + "&editzip=" + vend_zip + "&editcountry="+vend_country+"'>수정" + "</td><td>" +"<a href='/pro09/vendor?command=delMember&vendid="+vend_id+"'>삭제</a></td><tr>" );
			//pw.print("<tr><td>" + vend_id + "</td><td>" + vend_name +"</td><td>" + vend_address + "</td><td>" + vend_city +"</td><td>" + vend_state +"</td><td>"+ vend_zip +"</td><td>"+ vend_country +"</td><td>"+ "<a href='/pro09/edit?command=editMember&editid="+vend_id+"'>수정" + "</td><td>" +"<a href='/pro09/vendor?command=delMember&vendid="+vend_id+"'>삭제</a></td><tr>" ); 
		}
		
		pw.print("<br><a href='/pro09/vendorprint.html'>'고객 번호 입력창'</a><br>");
	}

}
