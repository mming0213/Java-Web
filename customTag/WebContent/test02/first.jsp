<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--다운로드할 파일 이름을 매개변수로 전달 --%>
	<form method="post" action="result.jsp" >
		<input type=hidden name="param1" value="duke.png" /><br>
		<input type=hidden name="param2" value="duke2.jpg" /><br>
		<input type="submit" value="이미지 다운로드">
	</form>
</body>
</html>