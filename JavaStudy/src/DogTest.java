import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;

class Dog {
	private String name;
	private int age;
	private String kind; // 품종
	private ArrayList inoculate = new ArrayList(); // 예방접종
	private HashSet handler = new HashSet();
	private HashMap family = new HashMap();

	Dog(String name, int age, String kind) {
		this.name = name;
		this.age = age;
		this.kind = kind;
	}

	// 예방접종을 하다
	// inoculate 속성에 이름과 날짜에 해당하는 예방접종 정보 저장하기 위해 Inoculate 클래스 만듬.
	void shotInoculate(String name, Date date) throws Exception {
		Inoculate in = new Inoculate(name, date);
		// 동일한 예방접종을 하면 안된다.
		if (inoculate.contains(in)) {
			throw new Exception("중복된 예방접종입니다.");
		}
		// 최신순으로 날짜 정렬 후 품종별 예방접종 가능 기간이 아니면 오류 발생
		Collections.sort(inoculate);

		Inoculate max = null;
		if (inoculate.size() > 0) {
			max = (Inoculate) inoculate.get(inoculate.size() - 1);// inoculate ArrayList 안에 마지막 객체 반환.

			long day = 0;
			if ("셰퍼드".equals(this.kind)) {
				day = diffOfDate(max.getDate().toString(), date.toString());
				if (day < 7) {
					throw new Exception("예방접종 가능기간이 아닙니다.");
				}
			} else if ("진도견".equals(this.kind)) {
				day = diffOfDate(max.getDate().toString(), date.toString());
				if (day < 10) {
					throw new Exception("예방접종 가능기간이 아닙니다.");
				}
			} else if ("보더콜리".equals(this.kind)) {
				day = diffOfDate(max.getDate().toString(), date.toString());
				if (day < 15) {
					throw new Exception("예방접종 가능기간이 아닙니다.");
				}
			}
		}

		inoculate.add(in);
	}

	// 날짜 사이 계산
	public long diffOfDate(String begin, String end) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date beginDate = format.parse(begin);
		java.util.Date endDate = format.parse(end);

		long diff = endDate.getTime() - beginDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
	}

	// 예방접종 이력을 날짜별 정렬하여 출력
	// 형식: ‘{0} - {1}’, {0}: 날짜, {1}:예방접종명
	// 날짜는 xxxx.xx.xx Format으로 출력한다
	public void printInoculateHistory() {
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Iterator it = inoculate.iterator();
		Iterator it2 = inoculate.iterator();

		while (it.hasNext() && it2.hasNext()) {
			System.out
					.println(f.format(((Inoculate) it2.next()).getDate()) + " - " + ((Inoculate) it.next()).getName());
		}
	}

	// Handler 추가
	// name/strDt/endDt가 동일한 값을 추가될 수 없다(중복x)
	public void addHandler(String name, String strDt, String endDt) throws Exception {
		Handler h = new Handler(name, strDt, endDt);
		if (handler.contains(h)) {
			throw new Exception("중복될 수 없습니다.");
		} else {
			handler.add(h);
		}
	}

	// Handler의 총 훈련기간을 리턴
	public int getTotalHandlerPeriod() throws ParseException {
		Iterator it = handler.iterator();

		int sum = 0;

		while (it.hasNext()) {
			Handler h = (Handler) it.next();
			String strDt = h.getstrDt();
			String endDt = h.getendDt();

			long lo = diffOfDate(strDt, endDt);

			sum += lo;
		}
		return sum;
	}

	// 가족 추가.
	// info는 type과 name으로 구성되며, /로 구분된다, 예)부견/낙동
	// type: 부견/모견/형재/자매, name: 이름
	// 이름은 중복 될 수 없다(key!!) 품종: 셰퍼드, 진도견, 보더콜리
	public void addFamily(String info) throws Exception {
		String data[] = info.split("/");
		Family f = new Family(data[1], data[0]);
		if (family.containsKey(data[1])) {
			throw new Exception("중복될 수 없습니다.");
		} else {
			family.put(data[1], data[0]);
		}
	}

	public void printFamily() {
		Set set = family.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Entry e = (Entry) it.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

}

class Family {
	private String type;
	private String name;

	Family(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Family) {
			return name.equals(((Family) obj).name);
		} else
			return false;
	}

	public int hashCode() {
		return Objects.hash(name, type);
	}
}

class Inoculate implements Comparable {
	private String name;
	private Date date;

	Inoculate(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Inoculate) {
			return name.equals(((Inoculate) obj).name);
		} else
			return false;
	}

	public int compareTo(Object obj) {
		Inoculate in = (Inoculate) obj;

		return date.toString().compareTo(in.getDate().toString());
	}
}

class Handler {
	private String name;
	private String strDt;
	private String endDt;

	Handler(String name, String strDt, String endDt) {
		this.name = name;
		this.strDt = strDt;
		this.endDt = endDt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setstrDt(String strDt) {
		this.strDt = strDt;
	}

	public String getstrDt() {
		return strDt;
	}

	public void setendDt(String endDt) {
		this.endDt = endDt;
	}

	public String getendDt() {
		return endDt;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Handler) {
			String thisTmp = name + strDt + endDt;
			String tmp = ((Handler) obj).getName() + ((Handler) obj).getstrDt() + ((Handler) obj).getendDt();
			return thisTmp.equals(tmp);
		} else
			return false;
	}

	public int hashCode() {
		return Objects.hash(name, strDt, endDt);
	}

}

public class DogTest {
	public static void main(String[] args) {
		Dog d = new Dog("캐빈", 10, "셰퍼드");

		try {
			d.shotInoculate("장티푸스", Date.valueOf("2019-07-01"));
			d.shotInoculate("장티푸스2", Date.valueOf("2019-08-01"));
			d.printInoculateHistory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			d.addHandler("염민주", "2019-07-01", "2019-07-17");
			// d.addHandler("염민주", "2019-07-01", "2019-07-17");
			d.addHandler("홍길동", "2019-07-01", "2019-07-17");
			d.addHandler("김길동", "2019-07-01", "2019-07-17");
			System.out.println(d.getTotalHandlerPeriod());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			d.addFamily("부견/낙동");
			d.addFamily("부견/낙동");
			d.addFamily("모견/나나");
			d.printFamily();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}