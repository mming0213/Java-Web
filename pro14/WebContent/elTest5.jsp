<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="chap08.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%> <!-- 표현 언어 기능 활성화 -->

<jsp:useBean id="m1" class="chap08.MemberBean" scope="page" />  <!-- 유즈빈(useBean)생성 -->
<jsp:setProperty name="m1" property="name" value="이순신" /> <!-- 빈의 name 속성에 값 설정 -->
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page" /> <!-- ArrayList 객체를 빈으로 생성 -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어의 여러 가지 연산자들</title>
</head>
<body>
	empty 연산자
	<h2>
		\${empty m1}: ${empty m1}<br>  <!-- m1의 name속성에 값이 설정되어있으므로 false 반환 -->
		\${not empty m1}: ${not empty m1}<br><br>
		
		\${empty m2}: ${empty m2}<br>  <!-- ArrayList 객체인 m2는 비어있으므로 true 반환 -->
		\${not empty m2}: ${not empty m2}<br><br>
		
		\${empty "hello"}: ${empty "hello"}<br>  <!-- 문자열에 대해 false 반환 -->
		\${empty null}: ${empty null}<br>  <!-- null은 true 반환 -->
		\${empty ""}: ${empty ""}<br><br>  <!-- 빈 문자열은 true 반환 -->
	</h2>

</body>
</html>