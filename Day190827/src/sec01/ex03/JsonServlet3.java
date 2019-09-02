package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet3
 */
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
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
		PrintWriter writer = response.getWriter();
		
		JSONObject totaObject = new JSONObject(); //�迭�� ���������� ������ JSONObject ��ü ����
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "������");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "��������");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "�迬��");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "Įġ");
		membersArray.add(memberInfo);
		totaObject.put("members", membersArray); //ȸ�� ������ ������ �迭�� �迭 �̸� members�� total
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookinfo = new JSONObject();
		bookinfo.put("title", "�ʺ��ڸ� ���� �ڹ� ���α׷���");
		bookinfo.put("writer", "�̺���");
		bookinfo.put("price", "3000");
		bookinfo.put("genre", "IT");
		bookinfo.put("image", "http://localhost:8090/Day190827/image/duke.png");
		bookArray.add(bookinfo);
		
		bookinfo = new JSONObject();
		bookinfo.put("title", "����� ���̽�");
		bookinfo.put("writer", "�̽���");
		bookinfo.put("price", "12000");
		bookinfo.put("genre", "IT");
		bookinfo.put("image", "http://localhost:8090/Day190827/image/duke2.jpg");
		bookArray.add(bookinfo);
		
		totaObject.put("books", bookArray);
		String jsonInfo = totaObject.toJSONString();
		System.out.println(jsonInfo);
		writer.print(jsonInfo);
		
	}
}
