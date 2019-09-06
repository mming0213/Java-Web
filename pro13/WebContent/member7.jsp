<%--<jsp:getProperty> 액션 태그를 이용해 useBean의 속성에 접근하여 값을 출력합니다. --%>

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
			<jsp:getProperty name="m" property="id" />
		</td>
		<td>
			<jsp:getProperty name="m" property="pwd" />
		</td>
		<td>
			<jsp:getProperty name="m" property="name" />
		</td>
		<td>
			<jsp:getProperty name="m" property="email" /> <%--<jsp:getProperty>태그를 이용해 useBean 속성 값에 접근 --%>
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