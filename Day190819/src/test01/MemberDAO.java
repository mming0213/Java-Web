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
			Context envContext = (Context)ctx.lookup("java:/comp/env");//JNDI�� �����ϱ� ���� �⺻ ���("java:/comp/env")�� ����.
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");//��Ĺ context.xml�� ������ name ���� jdbc/oracle�� �̿���
			 															//��Ĺ�� �̸� ������ DataSource�� �޾� �ɴϴ�.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection(); //DataSource�� �̿��� �����ͺ��̽��� �����մϴ�.
			String member_id = memberBean.getMember_id();
			String name = memberBean.getName();
			String pw = memberBean.getPassword();
			String check = memberBean.getCheck();
		
			System.out.println("MemberDAO-addMember :" + member_id + "/" + name);
			
			String query = "insert into member"; //Insert���� ���ڿ��� ����ϴ�.
			//query +=  " (member_id, name, password, regdate)";
			query +=  " values(?,?,?,sysdate)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member_id);   //insert���� �� '?'�� ������� ȸ�������� �����մϴ�.
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			pstmt.executeUpdate(); //ȸ�� ������ ���̺� �߰��մϴ�.
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
			pstmt.setString(1, member_id);   //insert���� �� '?'�� ������� ȸ�������� �����մϴ�.
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
