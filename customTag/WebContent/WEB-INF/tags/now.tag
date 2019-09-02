<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag import="java.util.Calendar" %>
<%
	Calendar cal = Calendar.getInstance();
%>
<%= cal.get(Calendar.YEAR) %>년
<%= cal.get(Calendar.MONTH)+1 %>월 
<%= cal.get(Calendar.DATE) %>일

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>