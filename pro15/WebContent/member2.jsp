<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="chap01.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding( "utf-8" );
    String command = (String)request.getAttribute("command");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 정보 출력창</title>
</head>
<body>
	
	<%-- List membersList = (List)request.getAttribute("membersList");--%>
	
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
	
	<c:forEach var="member" items="${membersList}" >
		<c:set var="change_id" value="${member.id}" />

	<%--
		
		for(int i = 0; i < membersList.size(); i++){
			MemberBean vo = (MemberBean)membersList.get(i);
			String id = vo.getId();
			String name = vo.getName();
			String address = vo.getAddress();
			String state = vo.getState();
			String zip = vo.getZip();
			String country = vo.getCountry();
			String contact = vo.getContact();
			String email = vo.getEmail();
	--%>
<c:url var="url1" value="testmember" >
		<c:param name="command" value="modSearch"  />
		<c:param name="id" value="${member.id }"  />
 		<c:param name="name" value="${member.name }"  />
		<c:param name="address" value="${member.address }"  />
		<c:param name="state" value="${member.state }"  />
		<c:param name="zip" value="${member.zip }"  />
		<c:param name="country" value="${member.country }"  />
		<c:param name="contact" value="${member.contact }"  />
		<c:param name="email" value="${member.email }"  /> 
</c:url>

	<tr align=center>
		<td>${member.id}</td>
		<td>${member.name}</td>
		<td>${member.address}</td>
		<td>${member.state}</td>
		<td>${member.zip}</td>
		<td>${member.country}</td>
		<td>${member.contact}</td>
		<td>${member.email}</td>
		<td><a href='${url1 }'>수정</a>
		
		
		<%--<td><a href="/pro15/testmember?command=modSearch&id=<%=id %>&name=<%=name %>&address=<%=address %>&state=<%=state %>&zip=<%=zip %>&country=<%=country %>&contact=<%=contact %>&email=<%=email %>">수정</a></td>--%>
	</tr>
	</c:forEach>
	
	<%--
		}

	<a href='/pro15/search.jsp'>고객번호 입력창으로</a>
	
	
	<a href='${url1 }'>고객번호 입력창으로</a>
	--%>
	</table>
</body>
</html>