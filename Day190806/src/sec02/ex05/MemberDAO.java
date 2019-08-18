package sec02.ex05;

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
	//private Statement stmt;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO memberVO)
	{
		boolean result = false;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		System.out.println("===ShowMember====");
		System.out.println(id+"/"+pwd);
		try {
			con = dataFactory.getConnection();
			String query = "select decode(count(*),1,'true','false') as result from t_member";
			query += " where id=? and pwd=?"; //오라클의 decode()함수를 이용해 조회하여 아이디와 비밀번호가 테이블에 존재하면 true, 존재하지 않으면 false 조회. 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result=" + result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
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
