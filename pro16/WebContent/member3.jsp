<%--빈 사용 실습--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec01.ex01.*"
    isELIgnored="false"%>
    
<%
	request.setCharacterEncoding("UTF-8"); //회원 정보를 표시하기 전에 한글 인코딩 설정
%>

<jsp:useBean id="m" class="sec01.ex01.MemberBean"  /> <%--회원 정보를 저장할 빈 생성 --%>
<jsp:setProperty name="m" property="*" /> <%--전송된 횐원 정보를 빈의 속성에 설정 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
		  <td width="20%"><b>아이디</b></td>
		  <td width="20%"><b>비밀번호</b></td>
		  <td width="20%"><b>이름</b></td>
		  <td width="20%"><b>이메일</b></td>
		</tr>
		<tr align = center>
		  <td><%=m.getId() %></td>
		  <td><%=m.getPwd() %></td>
		  <td><%=m.getName() %></td>
		  <td><%=m.getEmail() %></td> <%--표현식을 이용해 회원 정보 출력--%>
		</tr>
		<tr align = center>
		  <td>${m.id}</td>
		  <td>${m.pwd}</td>
		  <td>${m.name}</td>
		  <td>${m.email}</td> <%--빈 id와 속성 이름으로 접근해 회원 정보를 출력 --%>
		</tr>
	 </table>
</body>
</html>