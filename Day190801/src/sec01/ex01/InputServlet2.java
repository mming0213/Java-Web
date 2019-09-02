package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		Enumeration enu = request.getParameterNames(); //전송되어 온 name 속성들만 Enumeration 타입으로 받아옴.
		while(enu.hasMoreElements()) { //각 name을 하나씩 가져와 대응해서 전송되어 온 값을 출력.
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value:values)
			{
				System.out.println("name=" +name + ",value=" + value);
			}
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
		System.out.println("destroy 메서드 호출");
	}

}
