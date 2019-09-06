<%--<jsp:setProperty> 액션 태그를 이용해 유즈빈의 속성에 좀 더 편리하게 설정하는 방법 --%>
<%--먼저 회원 가입창(memberForm.html)의 각 입력창의 매개변수 이름을 자바 빈 속성 이름과 동일하게 설정합니다. --%>
<%--<jsp:setProperty> 액션 태그의 param 속성을 이용해 회원 가입창에서 전달된 매개변수 이름으로 해당 useBean의 속성에 자동으로 값을 설정합니다. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec01.ex01.*"
    pageEncoding="UTF-8"%>
  <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
  
  <%--회원 가입창에서 전달된 매개변수 이름과 속성 이름이 같으면 같은 이름으로 값을 설정합니다. --%> 
  <jsp:setProperty name="m" property="id" param="id" />
  <jsp:setProperty name="m" property="pwd" param="pwd" />
  <jsp:setProperty name="m" property="name" param="name" />
  <jsp:setProperty name="m" property="email" param="email" />
   
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