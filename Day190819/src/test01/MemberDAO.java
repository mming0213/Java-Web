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
			Context envContext = (Context)ctx.lookup("java:/comp/env");//JNDI에 접근하기 위해 기본 경로("java:/comp/env")를 지정.
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");//톰캣 context.xml에 설정한 name 값인 jdbc/oracle을 이용해
			 															//톰캣에 미리 연결한 DataSource를 받아 옵니다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection(); //DataSource를 이용해 데이터베이스와 연결합니다.
			String member_id = memberBean.getMember_id();
			String name = memberBean.getName();
			String pw = memberBean.getPassword();
			String check = memberBean.getCheck();
		
			System.out.println("MemberDAO-addMember :" + member_id + "/" + name);
			
			String query = "insert into member"; //Insert문을 문자열로 만듭니다.
			//query +=  " (member_id, name, password, regdate)";
			query +=  " values(?,?,?,sysdate)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member_id);   //insert문의 각 '?'에 순서대로 회원정보를 세팅합니다.
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			pstmt.executeUpdate(); //회원 정보를 테이블에 추가합니다.
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isExisted(MemberBean memberbean) {
		boolean result = false;
		String member_id = memberbean.getMember_id();
		String password = memberbean.getPassword();
		try {
			Connection con = dataFactory.getConnection(); 
			String query = "select decode(count(*),1,'true', 'false') as result from member";
			query += " where member_id=? and password=?" ;
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member_id);   //insert문의 각 '?'에 순서대로 회원정보를 세팅합니다.
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result=" + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public void changepassword(String newpassword, MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection();

			String password = memberBean.getPassword();
	
			System.out.println("MemberDAO-changepassword :" + newpassword + "/" + password);
			
			String query = "update member" +" set password=?" + " where password=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newpassword);
			pstmt.setString(2, password);
			
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
