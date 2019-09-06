<%--<jsp:setProperty> 액션 태그의 property 속성에 *를 지정하면 JSP페이지에서 자동으로 매개변수 이름과 --%>
<%--속성 이름을 비교한 후 같은 이름의 속성 이름에 전달된 값을 알아서 설정해줍니다. --%>
<%--JSP나 HTML 페이지에서 전달된 데이터를 처리할 때 미리 매개변수 이름과 속성 이름을 동일하게설정하여 편리하게 사용할 수 있습니다. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec01.ex01.*"
    pageEncoding="UTF-8"%>
  <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
  <%--전송된 매개변수 이름과 빈 속성을 비교한 후 동일한 빈에 값을 자동으로 설정합니다. --%>
  <jsp:setProperty name="m" property="*"  />
  
 <%
 request.setCharacterEncoding("utf-8");
 %>
  <%
 	/*String id = request.getParameter("id");
 	String pwd = request.getParameter("pwd");
 	String name = request.getParameter("name");
 	String email = request.getParameter("email");
 	//MemberBean m = new MemberBean(id, pwd, name, email);
 	
 	m.setId(id);
 	m.setPwd(pwd);
 	m.setName(name);
 	m.setEmail(email);*/
 	
 	
 	MemberDAO memberDAO = new MemberDAO();
 	memberDAO.addMember(m);
 	List membersList = memberDAO.listMembers();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
<table align="center" width="100%">
		<tr align=center bgcolor="#99ccff">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="5%">이름</td>
		<td width="11%">이메일</td>
		<td width="5%">가입일자</td>
		</tr>
		
	<%
		if(membersList.size() == 0){
	%>
	
	<tr>
		<td colspan="5">
		 <p align="center"><b><span style="font-size:9pt;">
		 	등록된 회원이 없습니다.</span></b></p>	
	</td>
	</tr>
	<%
		}else{
			for(int i= 0; i < membersList.size(); i++){
				MemberBean bean = (MemberBean)membersList.get(i);	
	%>
	
	<tr align="center">
		<td>
			<%=bean.getId() %>
		</td>
		<td>
			<%=bean.getPwd() %>
		</td>
		<td>
			<%=bean.getName() %>
		</td>
		<td>
			<%=bean.getEmail() %>
		</td>
		<td>
			<%=bean.getJoinDate() %>
		</td>
	</tr>
	<%
			}
		}
	%>
	
	<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
		</table>
	
</body>
</html>