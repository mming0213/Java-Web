package sec02.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowMember
 */
@WebServlet("/show")
public class ShowMember extends HttpServlet {
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = "";
		String pwd = "";
		Boolean isLogon = false;
		
		HttpSession session = request.getSession(false); //�̹� ������ �����ϸ� ������ ��ȯ�ϰ�, ������ null ��ȯ.
		if(session != null) //������ �����Ǿ� �ִ��� Ȯ��
		{
			isLogon = (Boolean)session.getAttribute("isLogon"); //isLogOn �Ӽ��� ������ �α��� ���� Ȯ��.
			System.out.println("===ShowMember====");
			System.out.println("isLogon: " + isLogon);
			if(isLogon == true)
			{
				id = (String)session.getAttribute("login.id");
				pwd = (String)session.getAttribute("login.pwd");  //isLogOn�� true�� �α��� �����̹Ƿ� ȸ�� ������ �������� ǥ��.
				System.out.println(id+"/"+pwd);
				out.print("<html><body>");
				out.print("���̵�: " + id+"<br>");
				out.print("��й�ȣ: " + pwd+"<br>");
				out.print("</body></html>"); 
			}
			else
			{
				response.sendRedirect("login3.html"); //�α��� ���°� �ƴϸ� �α���â���� �̵�.
			}
		}
		else
		{
			response.sendRedirect("login3.html"); //������ �������� �ʾ����� �α��� â���� �̵�.
		}
	
		
	}
	
}
