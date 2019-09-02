<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="optionMap" %>
<%@ attribute name="name" required="true" %> <%--type의 default는 string이므로 선언해주지 않아도됌. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name}">
	<c:forEach items="${optionMap}" var="option">
		<option value="${option.key}">${option.value}</option>
	</c:forEach>
</select>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>