package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8"); //���۵� �����͸� UTF-8�� ���ڵ�
		
		response.setContentType("text/html;charset=utf-8"); //setContentType�� �̿��� ������ ������ ������ HTML���� ����.
		PrintWriter out = response.getWriter(); //HttpServletResponse��ü�� getWriter()�� �̿��� ��� ��Ʈ�� PrintWriter ��ü�� �޾ƿ�.
		
		String user_id = request.getParameter("user_id"); //getParameter()�� �̿��� <input>��ũ�� name�Ӽ� ������ ���۵� value�� �޾ƿ�.
		String user_pw = request.getParameter("user_pw");
		System.out.println("���̵�:" + user_id);
		System.out.println("��й�ȣ:" + user_pw);
		
		String data = "<html>";
			data += "<body>";
			data += "���̵� : " + user_id;
			data += "<br>";
			data += "�н����� : " + user_pw;
			data += "</body>";
			data += "</html>";  //�������� ����� �����͸� ���ڿ��� �����ؼ� HTML �±׷� ����.
		out.print(data); //PrintWriter�� print()�� �̿��� HTML �±� ���ڿ��� �� �������� ���.	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
