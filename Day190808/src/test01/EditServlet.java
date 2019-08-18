package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");

		if(command != null && command.equals("editMember"))
		{
			System.out.println("공급업체 수정 되는지");
			
//			String originid = request.getParameter("editid");
//			System.out.println(originid);
			
			String _vendid = request.getParameter("editid");
			String _vendname = request.getParameter("editname");
			String _vendaddress = request.getParameter("editaddress");
			String _vendcity = request.getParameter("editcity");
			String _vendstate = request.getParameter("editstate");
			String _vendzip = request.getParameter("editzip");
			String _vendcountry = request.getParameter("editcountry");
			
			System.out.println("2.edit에서" + _vendid + _vendname + _vendaddress + _vendcity + _vendstate + _vendzip + _vendcountry );
//			MemberVO vo = new MemberVO();
//			
//			vo.setVend_id(_vendid);
//			vo.setVend_name(_vendname);
//			vo.setVend_address(_vendaddress);
//			vo.setVend_city(_vendcity);
//			vo.setVend_state(_vendstate);
//			vo.setVend_zip(_vendzip);
//			vo.setVend_country(_vendcountry);
//			
//			dao.editMember(originid, vo);
			
			
			out.print("<html><body><form name='frmedit' method='get' action='vendor' encType='UTF-8'>");
			out.print("공급업체 번호 : <input type='text' name='vend_id' value='"+_vendid+"' ><br>");
			out.print("공급업체 이름 : <input type='text' name='vend_name' value='"+_vendname+"'><br>");
			out.print("공급업체 주소 : <input type='text' name='vend_address' value='"+_vendaddress+"'><br>");
			out.print("공급업체 시 : <input type='text' name='vend_city' value='"+_vendcity+"'><br>");
			out.print("공급업체 주 : <input type='text' name='vend_state' value='"+_vendstate+"'><br>");
			out.print("공급업체 우편번호 : <input type='text' name='vend_zip' value='"+_vendzip+"'><br>");
			out.print("공급업체 국가 : <input type='text' name='vend_country'value='"+_vendcountry+"'><br>");
			out.print("<input type='submit' value='수정'>");
			out.print("<input type='reset' value='다시입력'>");
			out.print("<input type='hidden' name='originid' value='" + _vendid + "'>");
			out.print("<input type='hidden' name='command' value='editMember'>");
			out.print("</form></body></html>");
			

		}

	}
}
