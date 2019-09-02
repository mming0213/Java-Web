package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class customerlist
 */
@WebServlet("/cust")
public class CustomerServlet extends HttpServlet {
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

		JSONObject totaObject = new JSONObject();
		JSONObject error = new JSONObject();
		JSONObject memberInfo = new JSONObject();		
		String jsonInfo = null;
		
		String command = request.getParameter("command");
		String p_id = request.getParameter("id");
		String idCopy = request.getParameter("idCopy");
		
		
		MemberDAO dao = new MemberDAO();
		MemberBean vo = new MemberBean();
		List membersList;
		
		System.out.println("p_id=" + p_id);
		System.out.println("command=" + command);
		System.out.println("idCopy=" + idCopy);
		
		//try {
		if(command != null && command.equals("search")) {

			System.out.println("=============command=search========");
			membersList = search(p_id);
		
			jsonInfo = null;
			if(membersList.size() == 0) {
				error.put("error_yn", "Y");
				error.put("error_text", "고객이 존재하지 않습니다");
				
				totaObject.put("error", error);
				
				jsonInfo = totaObject.toJSONString();
				System.out.print(jsonInfo);
				writer.print(jsonInfo);		
				return;
			}
			
			vo = (MemberBean) membersList.get(0);
	
			System.out.println(vo.getId() + "/" + vo.getName() + "/" + vo.getAddress());
		}
		else if(command != null && command.equals("save"))
		{
			
			System.out.println("========save============");

			String id = request.getParameter("input01");
			String name = request.getParameter("input02");
			String address = request.getParameter("input03");
			String state = request.getParameter("input04");
			String zip = request.getParameter("input05");
			String country = request.getParameter("input06");
			String contact = request.getParameter("input07");
			String email = request.getParameter("input08");
			
			System.out.println("id="+ id + ",name:" + name + ",address:" + address);
			
			vo.setId(id);
			vo.setName(name);
			vo.setAddress(address);
			vo.setState(state);
			vo.setZip(zip);
			vo.setCountry(country);
			vo.setContact(contact);
			vo.setEmail(email);
			
			//boolean isExisted = dao.overlappedID(id);
			//System.out.println("기존 아이디 존재 여부:" + isExisted);
			
//			if(isExisted) {
//				dao.editMember(id, vo);
//			}
//			else {
//          }
			System.out.println("idCopy=" + idCopy);
			if(idCopy == "" && idCopy.equals("")) {
				System.out.println("idcopy가 null임");
				dao.addMember(vo);	
			}
			else {
				System.out.println("idcopy가 null이 아님");
				dao.editMember(id, vo);
			}
		
		}
		
			System.out.println("1111");
			memberInfo.put("check", vo.getId());
			memberInfo.put("id", vo.getId());
			memberInfo.put("name", vo.getName());
			memberInfo.put("address", vo.getAddress());
			memberInfo.put("state", vo.getState());
			memberInfo.put("zip", vo.getZip());
			memberInfo.put("country", vo.getCountry());
			memberInfo.put("contact", vo.getContact());
			memberInfo.put("email", vo.getEmail());
			totaObject.put("member", memberInfo);
			
			error.put("error_yn", "N");
			totaObject.put("error", error);	
			

			jsonInfo = totaObject.toJSONString();
			System.out.print(jsonInfo);
			writer.print(jsonInfo);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

	public List search(String id) {
		MemberDAO dao = new MemberDAO();
		MemberBean memberVO = new MemberBean();
		memberVO.setId(id);

		List membersList = dao.listMembers(memberVO);
		return membersList;
	}
}
