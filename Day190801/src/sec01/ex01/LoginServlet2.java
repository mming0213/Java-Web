package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		System.out.println("init �޼��� ȣ��");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8"); //�� ���������� ���۵� �������� ���ڵ� ����
		response.setContentType("text/html;charset=utf-8"); //setContentType()�� �̿��� ������ ������ ������ HTML���� ����.
		PrintWriter out = response.getWriter(); //HttpServletResponse ��ü�� getWriter()�� �̿��� ��� ��Ʈ�� PrintWriter ��ü�� �޾ƿ�.
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data = "<html>";
			data += "<body>";
			data += "���̵� : " + id;
			data += "<br>";
			data += "�н����� :" + pw;
			data += "</html>";
			data += "</body>";  //�������� ����� �����͸� ���ڿ��� �����ؼ� HTML �±׷� ����
			out.print(data); //PrintWriter�� print()�� �̿��� HTML �±� ���ڿ��� �� �������� ���.
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}

}
