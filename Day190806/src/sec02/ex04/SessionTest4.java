package sec02.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest4
 */
@WebServlet("/login4")
public class SessionTest4 extends HttpServlet {
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
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw"); //로그인창에서 전송된 ID와 비밀번호를 가져옴.
		if(session.isNew()) { //최초 요청 시 수행.
			if(user_id != null) {  //로그인 창에서 서블릿으로 요청했다면 ID가 null이 아니므로 세션에 ID를 바인딩함.
				session.setAttribute("user_id", user_id);
				out.println("<a href='login4'>로그인 상태 확인</a>");
			}else {
				out.print("<a href='login2.html'>다시 로그인하세요!!</a>");
				session.invalidate(); 
			}
		}else {
			user_id = (String)session.getAttribute("user_id");  //재요청 시 세션에서 ID를 가져와 이전에 로그인했는지 여부를 확인.
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요 " + user_id + "님!!!");
			}else {
				out.print("<a href='login2.html'>다시 로그인하세요!!</a>");
				session.invalidate(); 
			}
		}
		
	}

}
