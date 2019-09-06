package sec01.ex01;

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
	
	public List listMembers()
	{
		List list = new ArrayList();
		try {
			//connDB();
			con = dataFactory.getConnection();

			String query = "select * from t_member order by joinDate desc ";
			System.out.println("prepareStatement:" + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) 
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				MemberBean vo = new MemberBean();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
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
	
	public void addMember(MemberBean memberBean) {
		try {
	
			Connection con = dataFactory.getConnection();
			String id = memberBean.getId();
			String pwd = memberBean.getPwd();
			String name = memberBean.getName();
			String email = memberBean.getEmail();
	
			String query = "insert into t_member";
			query += " (id, pwd, name, email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public void delMember(String id)
//	{
//		try {
//			System.out.println("아디" + id);
//			Connection con = dataFactory.getConnection();
//			//Statement stmt = con.createStatement();
//			
//			String query = "delete from vendors" + " where TRIM(vend_id)=?";
//			System.out.println("prepareStatememt:" + query);
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, id);
//			pstmt.executeUpdate();
//			pstmt.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	

	
	
}
