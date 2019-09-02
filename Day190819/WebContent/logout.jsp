<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 처리 JSP</title>
</head>
<body>
<%
	if(session != null) 
	{
		session.invalidate();
		System.out.println("=======로그아웃 확인====");
	}
	
	response.sendRedirect("login.jsp");
%>
</body>
</html>