package Day190716;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class sqlDataTest2 {

	public Date transformDate(String date) {
		
		SimpleDateFormat beforFormat = new SimpleDateFormat("yyyymmdd");
		
		//Date�� �����ϱ� ���ؼ��� ��¥ ������ yyyy-mm-dd�� �����ؾ� �Ѵ�.
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			//���� yyyymmdd�� �� ��¥ �������� java.util.Date��ü�� �����.
			tempDate = beforFormat.parse(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//java.util.Date�� yyyy-mm-dd �������� �����Ͽ� String�� ��ȯ�Ѵ�.
		String transDate = afterFormat.format(tempDate);
		
		//��ȯ�� String ���� Data�� �����Ѵ�.
		Date d = Date.valueOf(transDate);
		
		return d;
	}
	
	public static void main(String[] args) {


		
	}

}
