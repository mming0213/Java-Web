package test01;

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
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers(String id)
	{
		List list = new ArrayList();
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select c.cust_id, c.cust_name, b.order_num, a.prod_id, d.prod_name" +
					" FROM orderitems a, orders b, customers c, products d" + 
					" WHERE c.cust_id = b.cust_id" +
					" AND b.order_num = a.order_num" +
					" AND a.prod_id = d.prod_id";
					//" AND c.cust_id = '" + id + "'";
			if(id != null && id.length() != 0) {
				query += " AND c.cust_id = '" + id + "'";
			}
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) 
			{
				String cust_id = rs.getString("cust_id");
				String cust_name = rs.getString("cust_name");
				String order_num = rs.getString("order_num");
				String prod_id = rs.getString("prod_id");
				String prod_name = rs.getString("prod_name");
				
				System.out.println(cust_id+cust_name);
				
				MemberVO vo = new MemberVO();
				vo.setCust_id(cust_id);;
				vo.setCust_name(cust_name);
				vo.setOrder_num(order_num);
				vo.setProd_id(prod_id);
				vo.setProd_name(prod_name);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//		//	stmt = con.createStatement();
//		//	System.out.println("Statement 생성 성공");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
