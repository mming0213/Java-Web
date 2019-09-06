<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>use Cookie</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
	for(int i = 0; i < cookies.length; ++i){
	if(cookies[i].getName().equals("id")){  //ID란 key로 저장된 Cookie value를 찾는다 
%>

</body>
</html>