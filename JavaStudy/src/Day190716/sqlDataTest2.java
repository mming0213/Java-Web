package Day190716;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class sqlDataTest2 {

	public Date transformDate(String date) {
		
		SimpleDateFormat beforFormat = new SimpleDateFormat("yyyymmdd");
		
		//Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			//현재 yyyymmdd로 된 날짜 형식으로 java.util.Date객체를 만든다.
			tempDate = beforFormat.parse(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
		String transDate = afterFormat.format(tempDate);
		
		//반환된 String 값을 Data로 변경한다.
		Date d = Date.valueOf(transDate);
		
		return d;
	}
	
	public static void main(String[] args) {


		
	}

}
