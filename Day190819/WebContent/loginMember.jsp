<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
	<script type="text/javascript">
		function fn_login(){
		var frmLogin = document.frmLogin;
		var member_id = frmLogin.member_id.value;
		var password = frmLogin.password.value;
		
		if(member_id.length = 0 || member_id == "")
		{
			alert("아이디를 입력하세요.");
			return false;
		}
		if(password.length = 0 || password == "")
		{
			alert("비밀번호를 입력하세요.");
			return false;
		}

	}
	</script>

<body>

	<form name="frmLogin" method="post" action="/Day190819/loginMember2.jsp" onsubmit="return checkValue()" encType="UTF-8">
		 ID: <input type="text" name="member_id"><br>
		 암호: <input type="password" name="password"><br>
	  <input type="submit" value="로그인" />
	</form>
</body>
</html>