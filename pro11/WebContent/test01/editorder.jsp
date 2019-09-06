<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec08.ex01.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		h1{
			text-align: center;
		}
	</style>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
<h1>주문 정보 출력</h1>
	<%
		//request.setCharacterEncoding("utf-8");
		//String _ordernum = request.getParameter("order_num");
		//System.out.println("입력한값"+_ordernum);
		//MemberVO memberVO = new MemberVO();
		//memberVO.setOrder_num(_ordernum);
		//MemberDAO dao = new MemberDAO();
		//List membersList=dao.listMembers(memberVO);
		String order_num = request.getParameter("num");
		String order_item = request.getParameter("item");
		String prod_id = request.getParameter("prodId");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String originId = request.getParameter("num");
		String originItem = request.getParameter("item");
	%>
	
	
	<form name='frmedit' method='get' action='../order' encType='UTF-8'>
		주문번호 : <input type='text' name='order_num'><br>
		주문항목번호 : <input type='text' name='order_item'><br>
		제품ID : <input type='text' name='prod_id'><br>
		항목수량 : <input type='text' name='quantity'><br>
		항목가격 : <input type='text' name='item_price'><br>
		<input type='submit' value='수정'><br>
		<input type='hidden' name='command' value='editMember'>
		
		<input type='hidden' name='columnid' value="<%=originId%>">
		<input type='hidden' name='columnitem' value="<%=originItem%>">
		
	</form>
	
</body>
</html>