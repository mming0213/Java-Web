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
	private String kind; // ǰ��
	private ArrayList inoculate = new ArrayList(); // ��������
	private HashSet handler = new HashSet();
	private HashMap family = new HashMap();

	Dog(String name, int age, String kind) {
		this.name = name;
		this.age = age;
		this.kind = kind;
	}

	// ���������� �ϴ�
	// inoculate �Ӽ��� �̸��� ��¥�� �ش��ϴ� �������� ���� �����ϱ� ���� Inoculate Ŭ���� ����.
	void shotInoculate(String name, Date date) throws Exception {
		Inoculate in = new Inoculate(name, date);
		// ������ ���������� �ϸ� �ȵȴ�.
		if (inoculate.contains(in)) {
			throw new Exception("�ߺ��� ���������Դϴ�.");
		}
		// �ֽż����� ��¥ ���� �� ǰ���� �������� ���� �Ⱓ�� �ƴϸ� ���� �߻�
		Collections.sort(inoculate);

		Inoculate max = null;
		if (inoculate.size() > 0) {
			max = (Inoculate) inoculate.get(inoculate.size() - 1);// inoculate ArrayList �ȿ� ������ ��ü ��ȯ.

			long day = 0;
			if ("���۵�".equals(this.kind)) {
				day = diffOfDate(max.getDate().toString(), date.toString());
				if (day < 7) {
					throw new Exception("�������� ���ɱⰣ�� �ƴմϴ�.");
				}
			} else if ("������".equals(this.kind)) {
				day = diffOfDate(max.getDate().toString(), date.toString());
				if (day < 10) {
					throw new Exception("�������� ���ɱⰣ�� �ƴմϴ�.");
				}
			} else if ("�����ݸ�".equals(this.kind)) {
				day = diffOfDate(max.getDate().toString(), date.toString());
				if (day < 15) {
					throw new Exception("�������� ���ɱⰣ�� �ƴմϴ�.");
				}
			}
		}

		inoculate.add(in);
	}

	// ��¥ ���� ���
	public long diffOfDate(String begin, String end) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date beginDate = format.parse(begin);
		java.util.Date endDate = format.parse(end);

		long diff = endDate.getTime() - beginDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
	}

	// �������� �̷��� ��¥�� �����Ͽ� ���
	// ����: ��{0} - {1}��, {0}: ��¥, {1}:����������
	// ��¥�� xxxx.xx.xx Format���� ����Ѵ�
	public void printInoculateHistory() {
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Iterator it = inoculate.iterator();
		Iterator it2 = inoculate.iterator();

		while (it.hasNext() && it2.hasNext()) {
			System.out
					.println(f.format(((Inoculate) it2.next()).getDate()) + " - " + ((Inoculate) it.next()).getName());
		}
	}

	// Handler �߰�
	// name/strDt/endDt�� ������ ���� �߰��� �� ����(�ߺ�x)
	public void addHandler(String name, String strDt, String endDt) throws Exception {
		Handler h = new Handler(name, strDt, endDt);
		if (handler.contains(h)) {
			throw new Exception("�ߺ��� �� �����ϴ�.");
		} else {
			handler.add(h);
		}
	}

	// Handler�� �� �ƷñⰣ�� ����
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

	// ���� �߰�.
	// info�� type�� name���� �����Ǹ�, /�� ���еȴ�, ��)�ΰ�/����
	// type: �ΰ�/���/����/�ڸ�, name: �̸�
	// �̸��� �ߺ� �� �� ����(key!!) ǰ��: ���۵�, ������, �����ݸ�
	public void addFamily(String info) throws Exception {
		String data[] = info.split("/");
		Family f = new Family(data[1], data[0]);
		if (family.containsKey(data[1])) {
			throw new Exception("�ߺ��� �� �����ϴ�.");
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
		Dog d = new Dog("ĳ��", 10, "���۵�");

		try {
			d.shotInoculate("��ƼǪ��", Date.valueOf("2019-07-01"));
			d.shotInoculate("��ƼǪ��2", Date.valueOf("2019-08-01"));
			d.printInoculateHistory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			d.addHandler("������", "2019-07-01", "2019-07-17");
			// d.addHandler("������", "2019-07-01", "2019-07-17");
			d.addHandler("ȫ�浿", "2019-07-01", "2019-07-17");
			d.addHandler("��浿", "2019-07-01", "2019-07-17");
			System.out.println(d.getTotalHandlerPeriod());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			d.addFamily("�ΰ�/����");
			d.addFamily("�ΰ�/����");
			d.addFamily("���/����");
			d.printFamily();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}