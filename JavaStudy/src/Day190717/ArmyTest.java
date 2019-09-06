package Day190717;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Army{
	private String name;
	private int age;
	private String grade;	//계급
	private String strDt;	//복무기간
	private String endDt;
	private Date nextHoliday;
	private Army[] sub = new Army[10];
	private int cnt = 0;
	
	Army(){
	}
	
	Army(String name, int age, String grade, String strDt, String endDt){
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.strDt = strDt;
		this.endDt = endDt;
		//this.nextHoliday = Holiday;
	}
	
	//grade별 야근수당 리턴
	public int getOverTimePayByClass() {
		if(grade.equals("일병")) return 100000;
		else if(grade.equals("상병")) return 200000;
		else if(grade.equals("병장")) return 300000;
		else return 0;
	}
	
	//부하별 야근수당을 출력한다.
	public void printSubOverTimePay() {
		DecimalFormat df = new DecimalFormat("#,###");
		for(int i = 0; i < cnt; i++) {
			if(sub[i] instanceof SpecialArmy) {
				
				int bouusSum = sub[i].getOverTimePayByClass() + ((SpecialArmy)sub[i]).getBonus();
				System.out.printf("%s의 야근수당은 %s입니다.\n", sub[i].name, bouusSum);
			}
			else if(sub[i] instanceof Army) {
				System.out.printf("%s의 야근수당은 %s입니다.\n", sub[i].name, df.format(sub[i].getOverTimePayByClass()));
			}
		}
	}
	
	//이번달의 남은 근무기간을 리턴한다.
	public int getTistMMPeriod() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyMMdd");
		Calendar c1 = Calendar.getInstance();
		//System.out.println(c1.get(Calendar.DATE));
		String strToday = sd.format(c1.getTime());//오늘 날짜
		String strTodayDay = strToday.substring(6, 8); //오늘날짜의 일수 구하기
		int ntoday = Integer.parseInt(strTodayDay);
		int endDay = c1.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("오늘 날짜 일수는 : " + ntoday + ", 마지막 일(현재 날짜 기준) : " + endDay);
		return endDay - ntoday;
	}
	
	
	//부하들 목록을 리턴한다.
	public void returnSub(Army[] sub) {
		for(int i = 0; i < sub.length; i++)
		{
			if(sub[i] != null) {
				cnt++;
			}
			else break; 
		}
		this.sub = sub;
	}
	
	//부하들을 출력한다.
	public void printSub() throws ParseException {
		for(int i = 0; i < cnt; i++) {
			SimpleDateFormat origianl_format = new SimpleDateFormat("yyyymmdd");
			SimpleDateFormat new_format = new SimpleDateFormat("yyyy-mm-dd");
			
			java.util.Date Start_origianl_date = origianl_format.parse(sub[i].strDt);
			String Start_new_date = new_format.format(Start_origianl_date);
			
			java.util.Date End_origianl_date = origianl_format.parse(sub[i].endDt);
			String End_new_date = new_format.format(End_origianl_date);

			if(sub[i] instanceof SpecialArmy) {
				System.out.println("우수 " + sub[i].name + " " + Start_new_date + " ~ " +  End_new_date);
			}
			else if(sub[i] instanceof Army) {
				System.out.println(sub[i].name + " " + Start_new_date + " ~ " +  End_new_date);
			}
		
		}
	}
	
}

class SpecialArmy extends Army{
	private int bonus;
	
	SpecialArmy(String name, int age, String grade, String strDt, String endDt, int bonus){
		super(name, age, grade, strDt, endDt);
		this.bonus = bonus;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}
}

public class ArmyTest {

	public static void main(String[] args) throws ParseException {
		
		Army am =  new Army("홍길동", 21, "병장", "20190201", "20190717");
		
		Army[] sub = new Army[10];
		sub[0] = new Army("김길동", 21, "일병", "20190201", "20190717");
		sub[1] = new Army("김철수", 22, "일병", "20180401", "20190717");
		sub[2] = new SpecialArmy("김우수", 23, "상병", "20180401", "20190717", 500000);

		am.returnSub(sub);
		am.printSub();
		
		System.out.println(am.getOverTimePayByClass());
		am.printSubOverTimePay();
		System.out.println(am.getTistMMPeriod());
		
	}
}
