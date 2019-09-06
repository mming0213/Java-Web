package sec08.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");//JNDI에 접근하기 위해 기본 경로("java:/comp/env")를 지정.
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");//톰캣 context.xml에 설정한 name 값인 jdbc/oracle을 이용해
			 															//톰캣에 미리 연결한 DataSource를 받아 옵니다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers(MemberVO memberVO)
	{
		List membersList = new ArrayList();
		String _ordernum = memberVO.getOrder_num();
		System.out.println("MemberDAO-listMembers:" + _ordernum);
		try {
			//connDB();
			con = dataFactory.getConnection();

			String query = "select * from orderitems";
			if((_ordernum!=null && _ordernum.length() != 0)) {
				//query += " where order_num=?";
				query += " where order_num like '%" + _ordernum + "%'";
				pstmt = con.prepareStatement(query);
				//pstmt.setString(1, _ordernum);
			}else {
				pstmt = con.prepareStatement(query);
			}
				
			System.out.println("prepareStatement:" + query);
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) 
			{
				String order_num = rs.getString("order_num");
				String order_item = rs.getString("order_item");
				String prod_id = rs.getString("prod_id");
				String quantity = rs.getString("quantity");
				String item_price = rs.getString("item_price");
				
				System.out.println(order_num+"/"+order_item+"/"+prod_id+"/");
				
				MemberVO vo = new MemberVO();
				vo.setOrder_num(order_num);
				vo.setOrder_item(order_item);
				vo.setProd_id(prod_id);
				vo.setQuantity(quantity);
				vo.setItem_price(item_price);
				
				membersList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return membersList;
		
	}
	
	public void delMember(String id)
	{
		try {
			System.out.println("아디" + id);
			Connection con = dataFactory.getConnection();
			//Statement stmt = con.createStatement();
			
			String query = "delete from vendors" + " where TRIM(vend_id)=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editMember(String originid, String originitem, MemberVO memberVO) {
		try {
			Connection con = dataFactory.getConnection();
			//Statement stmt = con.createStatement();
			String order_num = memberVO.getOrder_num();
			String order_item = memberVO.getOrder_item();
			String prod_id = memberVO.getProd_id();
			String quantity = memberVO.getQuantity();
			String item_price = memberVO.getItem_price();
			
			System.out.println("MemberDAO-editMember :" + originid +order_num +prod_id);
			
			String query = "update orderitems" +" set order_num=?, order_item=?, prod_id=?, quantity=?, item_price=?" + " where order_num=?";
			query += " AND order_item=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, order_num);
			pstmt.setString(2, order_item);
			pstmt.setString(3, prod_id);
			pstmt.setString(4, quantity);
			pstmt.setString(5, item_price);
			pstmt.setString(6, originid);
			pstmt.setString(7, originitem);
			
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
}
