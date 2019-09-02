<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="test01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 처리 JSP</title>
</head>
<body>
	<jsp:useBean id="m" class="test01.MemberBean" scope="request"  />
	<jsp:setProperty name="m"  property="*"  />
	
	<%
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		dao.addMember(m);
		response.sendRedirect("login.jsp");
	%>
	
	<%--<h1><%=m.getName() %>님 가입완료</h1>
	<a href=login.jsp>메인화면으로 이동</a> --%>
	
</body>
</html>