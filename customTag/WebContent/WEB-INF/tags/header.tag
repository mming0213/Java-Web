<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="true" %> <%--type의 default는 string이므로 선언해주지 않아도됌. --%>
<%@ attribute name="level" type="java.lang.Integer" %>
<%
	String headStartTag = null;
	String headEndTag = null;
	if(level == null){
		headStartTag="<h1>";
		headEndTag="</h1>";
	}else if(level == 1){
		headStartTag="<h1>";
		headEndTag="</h1>";
	}else if(level == 2){
		headStartTag="<h2>";
		headEndTag="</h2>";
	}else if(level == 3){
		headStartTag="<h3>";
		headEndTag="</h3>";
	}
%>
<%= headStartTag %>
${title}
<%= headEndTag %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>