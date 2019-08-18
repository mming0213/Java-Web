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
		request.setCharacterEncoding("utf-8"); //전송된 데이터를 UTF-8로 인코딩
		
		response.setContentType("text/html;charset=utf-8"); //setContentType을 이용해 응답할 데이터 종류가 HTML임을 설정.
		PrintWriter out = response.getWriter(); //HttpServletResponse객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴.
		
		String user_id = request.getParameter("user_id"); //getParameter()를 이용해 <input>태크의 name속성 값으로 전송된 value를 받아옴.
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디:" + user_id);
		System.out.println("비밀번호:" + user_pw);
		
		String data = "<html>";
			data += "<body>";
			data += "아이디 : " + user_id;
			data += "<br>";
			data += "패스워드 : " + user_pw;
			data += "</body>";
			data += "</html>";  //브라우저로 출력할 데이터를 문자열로 연결해서 HTML 태그로 만듬.
		out.print(data); //PrintWriter의 print()를 이용해 HTML 태그 문자열을 웹 브라우저로 출력.	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
