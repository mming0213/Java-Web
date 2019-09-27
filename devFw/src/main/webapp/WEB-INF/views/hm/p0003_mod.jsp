<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="sec02.ex01.*"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<jsp:useBean  id="p0003VO"  class="project.hm.p0003.vo.P0003VO"  scope="request"/> 
<%
   request.setCharacterEncoding( "utf-8" );
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script type="text/javascript">
	function frm_update() {
		var frmPro = document.frm;
		frmPro.method = "post";
		frmPro.action = "${contextPath}/hm/p0003/updateMember.do"; 
		frmPro.submit();
	}
	
	function frm_add() {
		var frmPro = document.frm;
		frmPro.method = "post";
		frmPro.action = "${contextPath}/hm/p0003/insertMember.do"; 
		frmPro.submit();
	}	
   </script>
</head>
<body>
	<form name="frm" method="post" encType="UTF-8">
	고객번호 :<input type="text" name="cust_id" value="${p0003VO.cust_id}"><br>
	<input type='hidden' name='key_id' value="${p0003VO.cust_id}"  /> 
	고객이름 :<input type="text" name="cust_name" value="${p0003VO.cust_name}"><br>
	고객주소 :<input type="text" name="cust_address" value="${p0003VO.cust_address}"><br>
	고객주 :<input type="text" name="cust_state" value="${p0003VO.cust_state}"><br>
	고객우편번호 :<input type="text" name="cust_zip" value="${p0003VO.cust_zip}"><br>
	고객국가 :<input type="text" name="cust_country" value="${p0003VO.cust_country}"><br>
	고객담당자 :<input type="text" name="cust_contact" value="${p0003VO.cust_contact}"><br>
	고객메일주소 :<input type="text" name="cust_email" value="${p0003VO.cust_email}"><br>
	
<c:if test="${command=='modSearch'}" > 	
	<input type="submit" name='submit' value="수정" onclick = "frm_update()">
	<input type='hidden' name='command' value='modUpdate'   /> 
</c:if>

<c:if test="${command=='addSearch'}" > 	
	<input type="submit" name='submit' value="추가" onclick = "frm_add()"> 
	<input type='hidden' name='command' value='addUpdate'   />
</c:if>	
	</form>
</body>
</html>