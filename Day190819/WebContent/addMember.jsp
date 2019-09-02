<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
</head>
	<script type="text/javascript">
		function checkValue(){
		var frmLogin = document.frmLogin;
		var member_id = frmLogin.member_id.value;
		var password = frmLogin.password.value;
		var check = frmLogin.check.value;
		
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
		if(frmLogin.password.value != frmLogin.check.value)
		{
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
	</script>

<body>
	<form name="frmLogin" method="post" action="/Day190819/addMember2.jsp" onsubmit="return checkValue()" encType="UTF-8">
	   ID: <input type="text" name="member_id"><br>
	   이름: <input type="text" name="name"><br>
	   암호: <input type="password" name="password"><br>
	    확인: <input type="password" name="check"><br>
	 <input type="submit" value="가입" />
	</form>
</body>
</html>