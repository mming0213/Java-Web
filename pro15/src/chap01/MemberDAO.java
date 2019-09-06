package chap01;

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
	
	public List listMembers(MemberBean memberBean)
	{
		List membersList = new ArrayList();
		String _id=memberBean.getId();
		
		System.out.println("아디확인"+_id);
		
		try {
			//connDB();
			con = dataFactory.getConnection();

			String query = "select * from customers";
			if((_id!=null && _id.length() != 0)) {
				query += " where cust_id=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, _id);
			}else {
				pstmt = con.prepareStatement(query);
			}
				
			System.out.println("prepareStatement:" + query);
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) 
			{
				System.out.println("=======meberDAO 확인=======");
				String id = rs.getString("cust_id");
				String name = rs.getString("cust_name");
				String address = rs.getString("cust_address");
				String state = rs.getString("cust_state");
				String zip = rs.getString("cust_zip");
				String country = rs.getString("cust_country");
				String contact = rs.getString("cust_contact");
				String email = rs.getString("cust_email");
				
				System.out.println(id+name+address+state);
				
				MemberBean vo = new MemberBean();
				vo.setId(id);
				vo.setName(name);
				vo.setAddress(address);
				vo.setState(state);;
				vo.setZip(zip);
				vo.setCountry(country);
				vo.setContact(contact);
				vo.setEmail(email);

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
	
	public void addMember(MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection(); //DataSource를 이용해 데이터베이스와 연결합니다.
			String id = memberBean.getId();
			String name = memberBean.getName();
			String address = memberBean.getAddress();
			String state = memberBean.getState();
			String zip = memberBean.getZip();
			String country = memberBean.getCountry();
			String contact = memberBean.getContact();
			String email = memberBean.getEmail();
		
			System.out.println("MemberDAO-addMember :" + id + "/" + name);
			
			
			String query = "insert into customers"; //Insert문을 문자열로 만듭니다.
			query +=  " (cust_id, cust_name, cust_address, cust_state, cust_zip, cust_country, cust_contact, cust_email)";
			query +=  " values(?,?,?,?,?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);   //insert문의 각 '?'에 순서대로 회원정보를 세팅합니다.
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, state);
			pstmt.setString(5, zip);
			pstmt.setString(6, country);
			pstmt.setString(7, contact);
			pstmt.setString(8, email);
			pstmt.executeUpdate(); //회원 정보를 테이블에 추가합니다.
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editMember(String originid, MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection();

			String id = memberBean.getId();
			String name = memberBean.getName();
			String address = memberBean.getAddress();
			String state = memberBean.getState();
			String zip = memberBean.getZip();
			String country = memberBean.getCountry();
			String contact = memberBean.getContact();
			String email = memberBean.getEmail();
		
			
			System.out.println("MemberDAO-editMember :" + originid + "/" + id + "/" + name);
			
			String query = "update customers" +" set cust_id=?, cust_name=?, cust_address=?, cust_state=?, cust_zip=?, cust_country=?, cust_contact=?, cust_email=?" + " where cust_id=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, state);
			pstmt.setString(5, zip);
			pstmt.setString(6, country);
			pstmt.setString(7, contact);
			pstmt.setString(8, email);
			pstmt.setString(9, originid);
			
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	

	
	
}
