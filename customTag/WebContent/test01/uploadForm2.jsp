<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--파일 업로드 시 반드시 encType을 multipart/form-data로 설정해야함. --%>
	<form action="${contextPath}/customTag/upload.do" method="post" enctype="multipart/form-data" >
		파일1:<input type="file" name="file1" ><br>
		파일2:<input type="file" name="file2" ><br>
		매개변수1: <input type="text" name="param1" ><br>
		매개변수2: <input type="text" name="param2" ><br>
		매개변수3: <input type="text" name="param3" ><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>