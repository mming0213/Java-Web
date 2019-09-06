package Day190717;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {
	//��, ��, ���� ���� �ԷµǾ��� ��� Date�� �����ϴ� �޼���
	public Date transformDate(String year, String month, String day) {
		String date = year+ "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		
		return d;
	}
	
	//��¥�� yyyymmdd �������� �ԷµǾ��� ��� Date�� �����ϴ� �޼���
	//valueOf(String) ��ȣ ���� �ش� ��ü�� String ��ü�� ��ȯ��Ű�� ����, String�� ��ü�� ����ȯ.
	public void transformDate(String date) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		//Date�� �����ϱ� ���ؼ��� ��¥ ������ yyyy-mm-dd�� �����ؾ��Ѵ�.
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			//���� yyyymmdd�� �� ��¥ �������� java.util.Date��ü�� �����. 
			tempDate = beforeFormat.parse(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//java.util.Date�� yyyy-mm-dd �������� �����Ͽ� String�� ��ȯ�Ѵ�.
		
		
		
		//return d;
	}
	
	public static void main(String[] args) {
		StringToDate st = new StringToDate();
		
		System.out.println(st.transformDate("2016","11","22"));
		//System.out.println(st.transformDate("20161101"));

	}

}
