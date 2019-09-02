<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%--함수를 사용하기 전에 반드시 선언합니다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함수 사용</title>
</head>
<body>
<c:set var="str1" value="Functions <태그>를 사용합니다." />
<c:set var="str2" value="사용" />
<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10" />

length(str1) = ${fn:length(str1)} <br>
toUpperCase(str1) = "${fn:toUpperCase(str1)}" <br>
toLowerCase(str1) = "${fn:toLowerCase(str1)}" <br>
substring(str1,3,6) = "${fn:substring(str1,3,6)}" <br>
substringAfter(str1,str2) = "${fn:substringAfter(str1,str2)}" <br>
substringBefore(str1,str2) = "${fn:substringBefore(str1,str2)}" <br>
trim(str1) = "${fn:trim(str1)}" <br>
replace(str1, src, dest) = "${fn:replace(str1, " ", "-")}" <br>
indexOf(str1, str2) = "${fn:indexOf(str1,str2)}" <br>
startsWith(str1, str2) = "${fn:startsWith(str1, "합니다.")}" <br>
endsWith(str1, str2) = "${fn:endsWith(str1,"합니다.")}" <br>
contains(str1, str2) = "${fn:contains(str1, str2)}" <br>
<%--fn:containsIgnoreCase(string, substring)
대소문자 관계없이 string이 substring을 포함하면 return true --%>
containsIgnoreCase(str1, str2) = "${fn:containsIgnoreCase(str1, str2)}" <br>

<c:set var="array" value="${fn:split(tokens,',')}" /><br>

join(array,"-") = "${fn:join(array,"-")}" <br>
<%--태그가 안먹고  Data로 인식하여 그대로 출력해줌. --%>
escapeXml(str1) = "${fn:escapeXml(str1)}" <br>

</body>
</html>