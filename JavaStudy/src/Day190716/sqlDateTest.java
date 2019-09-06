package Day190716;

import java.text.ParseException;

//import java.sql.*;

public class sqlDateTest {

	public static void main(String[] args) throws ParseException {
		
		//String -> java.sql.Date 변환
		String day = "2016-11-22";//형식을 지켜야함.
		java.sql.Date d = java.sql.Date.valueOf(day);
		System.out.println(d);
		
		//String -> java.sql.Timestamp 변환
		String day2 = "2016-11-22 11:22:30.0";//형식을 지켜야함.
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(day2);
		System.out.println(t);
		
		//String -> java.util.Date 변환
		String day3 = "20161122";
		java.util.Date d2 = new java.text.SimpleDateFormat("yyyyMMdd").parse(day3);
		System.out.println(d2);
		
		//java.util.Date -> java.sql.Date 변환
		java.util.Date u = new java.util.Date();
		java.sql.Date s = new java.sql.Date(u.getTime());
		System.out.println(s);
	}

}
