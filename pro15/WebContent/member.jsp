<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="chap01.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean  id="vo"  class="chap01.MemberBean"  scope="request"/> 
<c:set var="command" value="${param.command }" scope="request" />
<c:set var="change_id" value="${param.id }" scope="request" />

<%--
   request.setCharacterEncoding( "utf-8" );
   //MemberVO vo = (MemberVO)request.getAttribute("vo");
   String command = (String)request.getAttribute("command");
   String change_id = request.getParameter("id"); 
--%> 
<%
   request.setCharacterEncoding( "utf-8" );
%>

<!DOCTYPE html>
<html>
<head>
	<style>
		h1{
			text-align: center;
		}
	</style>
	<meta charset="UTF-8">
<title>고객 추가창</title>
</head>
<body>
	<form name="frm" method="post" action="testmember" encType="UTF-8">
	고객번호 :<input type="text" name="id" value="${vo.id}" /><br>
	고객이름 :<input type="text" name="name" value="${vo.name}" /><br>
	고객주소 :<input type="text" name="address" value="${vo.address}" /><br>
	고객주:<input type="text" name="state" value="${vo.state}" /><br>
	고객우편번호:<input type="text" name="zip" value="${vo.zip}" /><br>
	고객국가:<input type="text" name="country" value="${vo.country}" /><br>
	고객담당자:<input type="text" name="contact" value="${vo.contact}" /><br>
	고객메일주소:<input type="text" name="email" value="${vo.email}" /><br>
	
<c:if test="${command=='modSearch'}" > 	
	<input type="submit" name='submit' value="수정">
	<input type='hidden' name='command' value='modUpdate'   /> 
	<input type='hidden' name='change_id' value="${change_id }"   />
</c:if>	

<c:if test="${command=='addSearch'}" > 	
	<input type="submit" name='submit' value="추가"> 
	<input type='hidden' name='command' value='addUpdate'   />
</c:if>	
	<%--
	    if("modSearch".equals(command)){
	    System.out.println("=======command:modSearch====");
	
	
	<input type="submit" name='submit' value="수정">
	<input type='hidden' name='command' value='modUpdate'   /> 
	--%>	
	<%--  
		}
	--%>		

	<%--
	    if("addSearch".equals(command)){
	    	System.out.println("=======command:addSearch====");
	
	
	<input type="submit" name='submit' value="추가"> 
	<input type='hidden' name='command' value='addUpdate'   />
	--%>	
	<%--  
		}
	--%>	
	
	</form>
</body>
</html>