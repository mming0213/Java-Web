<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main form</title>
</head>
	<script type="text/javascript">
		function fn_login(){
		var frmLogin = document.frmLogin;
		var id = frmLogin.id.value;
		
			frmLogin.method = "post";
			frmLogin.action = "/Day190819/loginMember.jsp";
			frmLogin.submit();
		}
	</script>

<body>
	<form name="frmLogin" method="post" action="/Day190819/addMember.jsp">
	<input type="submit" value="회원가입하기">
	<input type="button" value="로그인하기" onClick="fn_login()">
	</form>
</body>
</html>