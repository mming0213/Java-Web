<%@ tag body-content="scriptless" pageEncoding="utf-8" %>
<%@ attribute name="length" type="java.lang.Integer" %>
<%@ attribute name="trail" %>
<%@ attribute name="trim" %>
<jsp:doBody var="content" scope="page" /> <%--몸체 내용을 context변수에 저장. content이름으로 setAttribute됨. --%>
<%
	String content = (String)jspContext.getAttribute("content");
	if(trim != null && trim.equals("true")){
		content = content.trim();
	}
	content = content.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?>", ""); 
	if(length != null && length.intValue() > 0 && content.length() > length.intValue()){
		content = content.substring(0, length.intValue());
		if(trail != null){
			content = content + trail;
		}
	}
%>
<%= content %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>