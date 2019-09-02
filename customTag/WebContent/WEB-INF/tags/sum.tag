<%@ tag pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="begin" required="true" type="java.lang.Integer" %>
<%@ attribute name="end" required="true" type="java.lang.Integer" %>

<%--
태그파일에서 EL변수를 추가하려면 variable 디렉티브를 사용하면 된다. 
<%@ variable name-given=“EL변수” variable-class=“변수타입” scope=“변수범위” />  
-name-given: 이 태그를 호출한 페이지에 추가할 변수이름
-variable-class: 추가될 변수의 타입을 지정. Defalut는 java.lang.String
- scope: 변수의 범위. AT_BEGIN/AT_END/NESTED, Default는 NESTED
--%>
<%@ variable name-given="sum" variable-class="java.lang.Integer" scope="NESTED" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="sum" value="${0}" />
<c:forEach var="num" begin="${begin}" end="${end}"> 
	<c:set var="sum" value="${sum + num}" /> 
</c:forEach> 
<jsp:doBody /> <%--body를 출력--%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>