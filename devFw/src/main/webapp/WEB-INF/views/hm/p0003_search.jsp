<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="sec02.ex01.*"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
text-align: center;
}
</style>
  <meta charset="UTF-8">
<title>회원 정보 출력창</title> 
</head>
<body>
<h1>회원 정보 출력</h1>
<%
   request.setCharacterEncoding( "utf-8" );
%>
<table border=1 width=800 align=center>
		<tr align=center bgcolor="FFFF66">
		<td>고객번호</td>
		<td>고객이름</td>
		<td>고객주소</td>
		<td>고객주</td>
		<td>고객우편번호</td>
		<td>고객국가</td>
		<td>고객담당자</td>
		<td>고객메일주소</td>
		<td>수정</td>
		</tr>

  <c:forEach var="member" items="${searchList}" >	
	 <c:url var="url"  value="searchMod.do"  >
	   <c:param  name="p_mod_id" value="${member.cust_id}" />
	 </c:url>     

     <tr align=center>
       <td>${member.cust_id}</td>
       <td>${member.cust_name}</td>
       <td>${member.cust_address}</td>
       <td>${member.cust_state}</td>
       <td>${member.cust_zip}</td>
       <td>${member.cust_country}</td>
       <td>${member.cust_contact}</td>
       <td>${member.cust_email}</td>
       <td><a href='${url}'> 수정 </a></td>
     </tr>
  </c:forEach>
</table>
</body>
</html>
