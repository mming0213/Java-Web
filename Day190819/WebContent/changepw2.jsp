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
<title>암호 변경 처리 JSP</title>
</head>
<body>
	<jsp:useBean id="m" class="test01.MemberBean" scope="request"  />
	<jsp:setProperty name="m"  property="*"  />
	
	<%
		request.setCharacterEncoding("utf-8");
		String password = request.getParameter("password");	
		String newpassword = request.getParameter("newpassword");
		System.out.println("password:" + password  +",newpassword:"+ newpassword);
		MemberDAO dao = new MemberDAO();
		dao.changepassword(newpassword, m);
		response.sendRedirect("logout.jsp");
	%>
	
	

</body>
</html>