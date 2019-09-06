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
		String user_pw = request.getParameter("user_pw"); //�α���â���� ���۵� ID�� ��й�ȣ�� ������.
		if(session.isNew()) { //���� ��û �� ����.
			if(user_id != null) {  //�α��� â���� ���������� ��û�ߴٸ� ID�� null�� �ƴϹǷ� ���ǿ� ID�� ���ε���.
				session.setAttribute("user_id", user_id);
				out.println("<a href='login4'>�α��� ���� Ȯ��</a>");
			}else {
				out.print("<a href='login2.html'>�ٽ� �α����ϼ���!!</a>");
				session.invalidate(); 
			}
		}else {
			user_id = (String)session.getAttribute("user_id");  //���û �� ���ǿ��� ID�� ������ ������ �α����ߴ��� ���θ� Ȯ��.
			if(user_id != null && user_id.length() != 0) {
				out.print("�ȳ��ϼ��� " + user_id + "��!!!");
			}else {
				out.print("<a href='login2.html'>�ٽ� �α����ϼ���!!</a>");
				session.invalidate(); 
			}
		}
		
	}

}