package Day190717;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {
	//년, 월, 일이 각각 입력되었을 경우 Date로 변경하는 메서드
	public Date transformDate(String year, String month, String day) {
		String date = year+ "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		
		return d;
	}
	
	//날짜가 yyyymmdd 형식으로 입력되었을 경우 Date로 변경하는 메서드
	//valueOf(String) 괄호 안의 해당 객체를 String 객체로 변환시키는 역할, String의 객체로 형변환.
	public void transformDate(String date) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		//Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야한다.
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			//현재 yyyymmdd로 된 날짜 형식으로 java.util.Date객체를 만든다. 
			tempDate = beforeFormat.parse(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
		
		
		
		//return d;
	}
	
	public static void main(String[] args) {
		StringToDate st = new StringToDate();
		
		System.out.println(st.transformDate("2016","11","22"));
		//System.out.println(st.transformDate("20161101"));

	}

}
