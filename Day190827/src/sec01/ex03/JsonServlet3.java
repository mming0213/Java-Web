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
		
		JSONObject totaObject = new JSONObject(); //배열을 최종적으로 저장할 JSONObject 객체 생성
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo);
		totaObject.put("members", membersArray); //회원 정보를 저장한 배열을 배열 이름 members로 total
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookinfo = new JSONObject();
		bookinfo.put("title", "초보자를 위한 자바 프로그래밍");
		bookinfo.put("writer", "이병승");
		bookinfo.put("price", "3000");
		bookinfo.put("genre", "IT");
		bookinfo.put("image", "http://localhost:8090/Day190827/image/duke.png");
		bookArray.add(bookinfo);
		
		bookinfo = new JSONObject();
		bookinfo.put("title", "모두의 파이썬");
		bookinfo.put("writer", "이승찬");
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
