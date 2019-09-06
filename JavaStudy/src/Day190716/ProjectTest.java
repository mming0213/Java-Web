package Day190716;

class Project {
	private String name;
	private String startDt;
	private String endDt;
	private String location;
	private Developer[] dev = new Developer[50];
	private int cnt = 0;
	// Developer[] developer = new Developer[50];
	//Developer d;

	Project() {
	}

	Project(String name, String startDt, String endDt, String location) {
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.location = location;
	}

	Project(String name, String startDt, String endDt, String location, Developer[] dev) {
		this(name, startDt, endDt, location);
		this.dev = dev;
	}

	public void process() {
		plan();
		// join(d);
		design();
		develop();
	}

	public void plan() {
		System.out.println("Project �غ�");
	}

	// Project�� ������ Add
	public void join(Developer d) {
		for(int i = 0; i < dev.length; i++)
		{
			if(dev[i] != null) {
				cnt++;
			}
			else break; 
		}
		dev[cnt] = d;
		 //dev[cnt++] = d;
		 //this.dev = d;
	}

	public void design() {
		System.out.println("�����۾�����");
	}

	public void develop() {
		System.out.println("�����۾�����");
	}

//	//Project �Ⱓ ����
//	public int getPeriod() {
//		return d.getPeriod();
//	}

	public int getMMByDeveloper() {
		int sum = 0;
		for (int i = 0; i < cnt; i++) {
			sum += dev[i].getPeriod();
		}
		return sum;
	}

	public void printDeveloper() {
		for (int i = 0; i < dev.length; i++) {
			Object obj = dev[i];
			if (obj != null && obj instanceof HighDeveloper) {
				System.out.println(
						"��ް����� " + dev[i].getName() + "/Ư�� " + ((HighDeveloper) dev[i]).getspecialSkill());
			} else if (obj != null && obj instanceof Developer) {
				System.out.println("�Ϲݰ����� " + dev[i].getName());
			}
		}
	}

}

class HrProject extends Project {
//	HrProject(){
//	}
//	
//	HrProject(String name, String startDt, String endDt, String location) {
//		super(name, startDt, endDt, location);
//	}
//	
	HrProject(String name, String startDt, String endDt, String location, Developer[] day) {
		super(name, startDt, endDt, location, day);
	}

	public void design() {
		System.out.println("HR �����۾�����");
	}

	public void develop() {
		System.out.println("HR �����۾�����");
	}
}

class Developer {
	private String name;
	private int period;

	Developer(String name, int period) {
		this.name = name;
		this.period = period;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getPeriod() {
		return period;
	}
}

class HighDeveloper extends Developer {
	private String specialSkill;

	HighDeveloper(String name, int period, String specialSkill) {
		super(name, period);
		this.specialSkill = specialSkill;
	}

	public void setspecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

	public String getspecialSkill() {
		return specialSkill;
	}
}

public class ProjectTest {

	public static void main(String[] args) {
//		Project pro = new Project("ERP", "20190701", "20190715", "����");
//
//		Developer p1 = new Developer("ȫ�浿", 10);
//		Developer p2 = new Developer("��浿", 7);
//		Developer p3 = new Developer("����", 5);
//		HighDeveloper p4 = new HighDeveloper("����", 12, "java");
//		Developer[] devArr = {p1,p2,p3};

		Developer[] dp = new Developer[10];
		dp[0] = new Developer("ȫ�浿", 10);
		dp[1] = new Developer("��浿", 7);
		dp[2] = new HighDeveloper("����", 5, "C#");
		
		Project pj = new Project("������Ʈ1", "20180101", "20190801", "location", dp);
		HighDeveloper extra = new HighDeveloper("����", 3, "c++");
		pj.process();
		
		pj.join(extra);// ���� �����ڵ鿡 extra������ �߰�
		pj.printDeveloper();
		
		
		
//		pro.join(p1);
//		pro.join(p2);
//		pro.join(p3);
//		pro.join(p4);
//		System.out.println(pro.getMMByDeveloper());
//		pro.process();
//	
//		pro.printDeveloper();

	}

}
