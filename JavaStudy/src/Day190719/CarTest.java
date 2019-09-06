package Day190719;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import java.util.Objects;
import java.util.Set;

class Car{
	private String model;
	private int efficiency;
	private int distance;
	private HashMap fixHis = new HashMap(); //수리이력
	private String nowOwner;
	private HashSet accidentHis = new HashSet();
	
	Car(String model, int efficiency, int distance, String nowOwner){
		this.model = model;
		this.efficiency = efficiency;
		this.distance = distance;
		this.nowOwner = nowOwner;
	}
	
	//사고 이력 추가.
	//info: location(장소), date(20190102), time(12:50)이 / 를 구분자로 add
    //로타리사거리/20190501/14:00
    //같은 사고이력을 추가할 수 없다
    //잘못된 날자와 시간이 추가되면 안된다
	public void addAccidentHis(String info) throws Exception{
		String data[] = info.split("/");

		//if(Util.validationDate(data[1] + " " + data[2])) {
		if(accidentHis.contains(data))
		{
			Accident ac = new Accident(data[0], data[1], data[2]);
			accidentHis.add(ac);
		}
		else {
			throw new Exception("날짜 Format이 정확하지 않습니다.");
		}
	}
	
	//사고 이력 출력.
	//형식: ‘{0} - {1} ? {2}’, {0}: 장소, {1}: 날자, {2}: 시간
    //날짜는 xxxx.xx.xx Format으로 출력한다
	public void printAccidentHis() throws ParseException{
		SimpleDateFormat original_format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat new_format = new SimpleDateFormat("yyyy.MM.dd");
	
		Iterator it = accidentHis.iterator();
		
		while(it.hasNext()) {
			Accident a = (Accident)it.next();

			java.util.Date original_date = original_format.parse(a.getDate());
			String new_date = new_format.format(original_date);
			System.out.println(a.getLocation() + "-" + new_date + "-" + a.getTime());			
		}
	}
	
	//수리 이력 추가
	//date별 item(수리부품)의 fixcmt(수리이력)을 추가한다
    //date별 item(수리부품)은 중복될 수 없다
	public void addFixHis(String date, String item, String fixcmt) throws Exception {
		//Fix f = new Fix(date, item, fixcmt);
		
		String strKey = date + "/" + item;
		//System.out.println(strKey); //20190717/범퍼
		String strFixinfo = date + "/" + item + "/" + fixcmt;
		if(fixHis.containsKey(strKey)) {
			throw new Exception("같은 수리부품은 중복 될 수 없습니다.");
		}
		else{
			fixHis.put(strKey, strFixinfo);
		}
	}
	
	//수리이력 출력
	//날짜 - 부분 - 수리Cmt를 출력한다
	public void printFixHis() {
		Set set = fixHis.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Entry e = (Entry) it.next();
			System.out.println(e.getValue());
		}
	}
}

class Fix{
	private String date;
	private String item;
	private String fixcmt;
	
	Fix(String date, String item, String fixcmt){
		this.date = date;
		this.item = item;
		this.fixcmt = fixcmt;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getItem() {
		return item;
	}
	
	public void setFixcmt(String fixcmt) {
		this.fixcmt = fixcmt;
	}
	
	public String getFixcmt() {
		return fixcmt;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Fix) {
			String thisTmp = date + "/" + item;
			String tmp = ((Fix)obj).getDate() + "/" + ((Fix)obj).getItem();
			
			return thisTmp.equals(tmp);
		} 
		else return false;		
	}
	
	public int hashCode() {
		return Objects.hash(date, item);
	}
	
}

class Accident {
	private String location;
	private String date;
	private String time;
	
	Accident(String location, String date, String time){
		this.location = location;
		this.date = date;
		this.time = time;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Accident) {
			String thisTmp = location + date + time;
			String tmp = ((Accident) obj).getLocation() + ((Accident) obj).getDate() + ((Accident) obj).getTime();
			return thisTmp.equals(tmp);
		} else
			return false;
	}
	
	public int hashCode() {
		return Objects.hash(location, date, time);
	}
	
	
}

public class CarTest {

	public static void main(String[] args) {
		Car ac = new Car("미니쿠퍼", 100, 100, "홍길동");
		
		try {
			ac.addAccidentHis("로타리사거리/20190512/02:00");
			//ac.addAccidentHis("로타리사거리/20190501/13:00");
			ac.addAccidentHis("로타리사거리2/20190719/10:37");
			ac.printAccidentHis();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			ac.addFixHis("20190717", "범퍼", "교체");
			//ac.addFixHis("20190717", "범퍼", "교체");
			ac.addFixHis("20190718", "범퍼", "교체");
			ac.printFixHis();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

class Util{
	public static boolean validationDate(String date) {
		//setLenient(boolean lenient) : 날짜가 파싱될 때 허술하게 할지말지를 설정.
		//이렇게 체크할 경우, 유효한 날짜가 아니면 ParseException을 던질것이고, 유효한 날짜라면 true로 반환.
		try {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd HH:mm");
			dateformat.setLenient(false);
			dateformat.parse(date);
			return true;
		}catch(ParseException e) {
			return false;
		}
		
	}
}
