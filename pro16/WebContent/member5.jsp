<%--HashMap 사용 실습 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="sec01.ex01.*"
    isELIgnored="false"%>
    
<%
	request.setCharacterEncoding("UTF-8"); //회원 정보를 표시하기 전에 한글 인코딩 설정
%>

<jsp:useBean id="m1" class="sec01.ex01.MemberBean"  />
<jsp:setProperty name="m1" property="*" />
<jsp:useBean id="membersList" class="java.util.ArrayList" />  <%--MemberBean객체를 저장할 ArrayList객체를 생성 --%>
<jsp:useBean id="membersMap" class="java.util.HashMap" />   <%--회원 정보를 저장할 HashMap객체를 <useBean>액션 태그를 이용해 생성 --%>

<%
	membersMap.put("id", "park2");
	membersMap.put("pwd", "4321");
	membersMap.put("name", "박지성");
	membersMap.put("email", "park2@test.com"); //HashMap에 key/value 쌍으로 회원정보를 저장.
	
	MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com"); //
	membersList.add(m1); 
	membersList.add(m2);
	membersMap.put("membersList", membersList);
%>

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
		  <td>${membersMap.id}</td>
		  <td>${membersMap.pwd}</td>
		  <td>${membersMap.name}</td>
		  <td>${membersMap.email}</td> <%--HashMap 이름 뒤에.(마침표)연산자로 저장 시 사용한 key를 사용하여 value를 가져옴. --%>
		</tr>
		<tr align = center>
		  <td>${membersMap.membersList[0].id}</td>
		  <td>${membersMap.membersList[0].pwd}</td>
		  <td>${membersMap.membersList[0].name}</td>
		  <td>${membersMap.membersList[0].email}</td> 
		</tr>
		<tr align = center>
		  <td>${membersMap.membersList[1].id}</td>
		  <td>${membersMap.membersList[1].pwd}</td>
		  <td>${membersMap.membersList[1].name}</td>
		  <td>${membersMap.membersList[1].email}</td> 
		</tr>
	 </table>
</body>
</html>