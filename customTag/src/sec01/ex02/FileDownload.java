package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
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
		response.setContentType("text/html; charset=utf-8");
		String file_repo = "C:\\file_repo";
		String fileName=(String)request.getParameter("fileName"); //매개변수로 전송된 파일 이름을 읽어옴.
		System.out.println("fileName="+fileName);
		OutputStream out = response.getOutputStream(); //response에서 OutputStream객체를 가져옴.
		String downFile=file_repo+"\\"+fileName;
		System.out.println("확인:" + downFile);
		
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("content-disposition", "attachment;fileName=" + fileName); //파일을 다운로드 할 수 있음.
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8]; //버퍼 기능을 이용해 파일에서 버퍼로 데이터를 읽어와 한꺼번에 출력함.
		while(true) {
			int count = in.read(buffer);
			if(count == -1) break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		}
	

}
