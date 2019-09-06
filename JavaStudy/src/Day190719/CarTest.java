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
	private HashMap fixHis = new HashMap(); //�����̷�
	private String nowOwner;
	private HashSet accidentHis = new HashSet();
	
	Car(String model, int efficiency, int distance, String nowOwner){
		this.model = model;
		this.efficiency = efficiency;
		this.distance = distance;
		this.nowOwner = nowOwner;
	}
	
	//��� �̷� �߰�.
	//info: location(���), date(20190102), time(12:50)�� / �� �����ڷ� add
    //��Ÿ����Ÿ�/20190501/14:00
    //���� ����̷��� �߰��� �� ����
    //�߸��� ���ڿ� �ð��� �߰��Ǹ� �ȵȴ�
	public void addAccidentHis(String info) throws Exception{
		String data[] = info.split("/");

		//if(Util.validationDate(data[1] + " " + data[2])) {
		if(accidentHis.contains(data))
		{
			Accident ac = new Accident(data[0], data[1], data[2]);
			accidentHis.add(ac);
		}
		else {
			throw new Exception("��¥ Format�� ��Ȯ���� �ʽ��ϴ�.");
		}
	}
	
	//��� �̷� ���.
	//����: ��{0} - {1} ? {2}��, {0}: ���, {1}: ����, {2}: �ð�
    //��¥�� xxxx.xx.xx Format���� ����Ѵ�
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
	
	//���� �̷� �߰�
	//date�� item(������ǰ)�� fixcmt(�����̷�)�� �߰��Ѵ�
    //date�� item(������ǰ)�� �ߺ��� �� ����
	public void addFixHis(String date, String item, String fixcmt) throws Exception {
		//Fix f = new Fix(date, item, fixcmt);
		
		String strKey = date + "/" + item;
		//System.out.println(strKey); //20190717/����
		String strFixinfo = date + "/" + item + "/" + fixcmt;
		if(fixHis.containsKey(strKey)) {
			throw new Exception("���� ������ǰ�� �ߺ� �� �� �����ϴ�.");
		}
		else{
			fixHis.put(strKey, strFixinfo);
		}
	}
	
	//�����̷� ���
	//��¥ - �κ� - ����Cmt�� ����Ѵ�
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
		Car ac = new Car("�̴�����", 100, 100, "ȫ�浿");
		
		try {
			ac.addAccidentHis("��Ÿ����Ÿ�/20190512/02:00");
			//ac.addAccidentHis("��Ÿ����Ÿ�/20190501/13:00");
			ac.addAccidentHis("��Ÿ����Ÿ�2/20190719/10:37");
			ac.printAccidentHis();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			ac.addFixHis("20190717", "����", "��ü");
			//ac.addFixHis("20190717", "����", "��ü");
			ac.addFixHis("20190718", "����", "��ü");
			ac.printFixHis();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

class Util{
	public static boolean validationDate(String date) {
		//setLenient(boolean lenient) : ��¥�� �Ľ̵� �� ����ϰ� ���������� ����.
		//�̷��� üũ�� ���, ��ȿ�� ��¥�� �ƴϸ� ParseException�� �������̰�, ��ȿ�� ��¥��� true�� ��ȯ.
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
