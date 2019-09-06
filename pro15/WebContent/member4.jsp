<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="chap01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding( "utf-8" );
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 정보 출력창</title>
</head>
<body>
	
<jsp:useBean id="m" class="chap01.MemberBean" scope="request"  />
<jsp:setProperty name="m"  property="*"  />

	<%
		request.setCharacterEncoding("utf-8");
		List membersList = (List)request.getAttribute("membersList");
		
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
		
	<%
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
	%>
	
	<tr align=center>
		<td><%=id %></td>
		<td><%=name %></td>
		<td><%=address %></td>
		<td><%=state %></td>
		<td><%=zip %></td>
		<td><%=country %></td>
		<td><%=contact %></td>
		<td><%=email %></td>
		<td><a href="/pro15/testmember?command=modSearch&id=<%=id %>&name=<%=name %>&address=<%=address %>&state=<%=state %>&zip=<%=zip %>&country=<%=country %>&contact=<%=contact %>&email=<%=email %>">수정</a></td>
	</tr>

	<%
		}
	%>
	
	<a href='/pro15/search.jsp'>고객번호 입력창으로</a>
	
	</table>
</body>
</html>