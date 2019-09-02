package sec03.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//ȸ�� ���� ��ȸ SQL���� �����Ͽ� ��ȸ�� ���ڵ���� �÷����� �ٽ� MemberVO ��ü�� �Ӽ��� ������ ���� ArrayList�� �����ϰ� ȣ���� ������ ��ȯ.
public class MemberDAO {
	
//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";  //�� �̻� ������ �����Ƿ� �ּ�ó��.
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	//private Statement stmt;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env"); //JNDI�� �����ϱ� ���� �⺻ ���(java:/comp/env)�� ����.
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle"); //��Ĺ context.xml�� ������ name���� jdbc/oracle�� �̿���
																		//��Ĺ�� �̸� ������ DataSource�� �޾ƿ�.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List list = new ArrayList();
		try {
			//connDB(); //�װ��� ������ �����ͺ��̽��� ����.
			con = dataFactory.getConnection(); //DataSource�� �̿��� �����ͺ��̽��� ����.
			String query = "select * from t_member ";
			System.out.println(query);
			//ResultSet rs = stmt.executeQuery(query); //SQL������ ȸ�� ���� ��ȸ
			pstmt = con.prepareStatement(query); //prepareStatement() �޼��忡 SQL���� ������ PrepareStatement ��ü�� ����.
			ResultSet rs = pstmt.executeQuery(); //executeQuery() �޼��带 ȣ���� �̸� ������ SQL���� ����.
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate"); //��ȸ�� ���ڵ��� �� �÷� ���� �޾ƿ�.
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate); //�� �÷� ���� �ٽ� MemberVO ��ü�� �Ӽ��� ����.
				list.add(vo); //������ MemberVO ��ü�� �ٽ� ArrayList�� ����.
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list; //��ȸ�� ���ڵ��� ������ŭ MemberVO��ü�� ������ ArrayList�� ��ȯ.
	}
	
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle ����̹� �ε� ����");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection ���� ����");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

}
