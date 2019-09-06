package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw"); //�Ѱ��� ���۵� ���� getParameter()�� �̿�
		System.out.println("���̵�:" + user_id);
		System.out.println("��й�ȣ:" + user_pw);
		String[] subject = request.getParameterValues("subject"); //�ϳ��� name���� ���� ���� �����ϴ� ��� getParameterValues()�� �̿��� �迭 ���·� ��ȯ
		for(String str:subject) {
			System.out.println("������ ����:" + str);
		}
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