package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
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
	
	public boolean overlappedID(String id) {
		boolean result = false;
		try{
				con = dataFactory.getConnection();

				String query = "select decode(count(*),1,'true','false') as result from t_member";
				query += " where id=?";
				System.out.println("prepareStatmemt : " + query);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);

				ResultSet rs = pstmt.executeQuery();	
				rs.next();
				result = Boolean.parseBoolean(rs.getString("result"));
				
				pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	


}
