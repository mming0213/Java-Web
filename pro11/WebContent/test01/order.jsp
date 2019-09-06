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
<title>주문 번호 출력창</title>
</head>
<body>
	<h1>주문 정보 출력</h1>
	
	<table border=1 width=800 align=center>
		<tr align=center bgcolor="FFFF66">
		<td>주문번호</td>
		<td>주문항목번호</td>
		<td>제품ID</td>
		<!-- <td>제품명</td> -->
		<td>항목수량</td>
		<td>항목삭제</td>
		<td>수정</td>
		<td>삭제</td>
		</tr>
		
	<%
		List membersList= (List)request.getAttribute("membersList");
	
		for(int i = 0; i < membersList.size(); i++){
			MemberVO vo = (MemberVO)membersList.get(i);
			String order_num = vo.getOrder_num();
			String order_item = vo.getOrder_item();
			String prod_id = vo.getProd_id();
			//String prod_name = vo.getProd_name();
			String quantity = vo.getQuantity();
			String item_price = vo.getItem_price();
	%>
	
	<tr align=center>
		<td><%=order_num %></td>
		<td><%=order_item %></td>
		<td><%=prod_id %></td>
		<td><%=quantity %></td>
		<td><%=item_price %></td>
		<td><a href="/pro11/test01/editorder.jsp?command=editMember&num=<%=order_num %>&item=<%=order_item %>&prodId=<%=prod_id %>&quantity=<%=quantity %>&price=<%=item_price %>">수정</a></td>
		<td><a href="/pro09/vendor">삭제</a></td>
	</tr>
	<%
	}
	%>
	
	</table>
	<a href='/pro11/OrderSearch.jsp'>주문번호 창으로</a>
	
</body>
</html>