<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객번호 입력창</title>
	<script type="text/javascript">
	function fn_addMember(){
		var searchMember = document.searchMember;
		var id = searchMember.id.value;
		
			searchMember.method = "post";
			searchMember.action = "/pro15/testmember";
			searchMember.command.value = "addSearch";
			searchMember.submit();
		
	}
	</script>
</head>
<body>
	<form name="searchMember" method="post" action="/pro15/testmember">
	<h1>고객번호 입력창 </h1><br>
		
	고객번호 : <input type="text" name="id">
		
	<input type="submit" value="조회">
	<input type="button" value="고객추가" onClick="fn_addMember()">
	<input type="hidden" name="command" value="search">
	</form>

</body>
</html>