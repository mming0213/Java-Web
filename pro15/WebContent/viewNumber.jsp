<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="chap02.FormatUtil"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("price", 12345L);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL함수 호출</title>
</head>
<body>
	가격은<b>${FormatUtil.number(price,"#,##0")}</b>원입니다.
</body>
</html>