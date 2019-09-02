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
<title>로그인 처리 JSP</title>
</head>
	<script type="text/javascript">
		function fn_login(){
		var frmLogin = document.frmLogin;
		var id = frmLogin.id.value;
		
			frmLogin.method = "post";
			frmLogin.action = "/Day190819/changepw.jsp";
			frmLogin.submit();
		
		}
	</script>
<body>
	<jsp:useBean id="m" class="test01.MemberBean" scope="request"  />
	<jsp:setProperty name="m"  property="*"  />
	
	<%
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");	
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(m);
		if(result){
			session.setAttribute("isLogon", true);
			session.setAttribute("member_id", member_id);
			session.setAttribute("password", password);
	%>

		<h1>안녕하세요.<%=m.getMember_id() %></h1>
		
		<form name="frmLogin" method="post" action="/Day190819/logout.jsp">
		<input type="submit" value="로그아웃하기">
		
		<input type="button" value="암호변경" onClick="fn_login()">
		<input type="hidden" name="command" value="search">
	<%
		}else{
	%>
		<h1>회원 아이디가 틀립니다.</h1>
		<a href = loginMember.jsp>다시 로그인하기</a>
		<%
			session.invalidate();
		%>
		
	<%
		}
	%>
	
	</form>
</body>
</html>