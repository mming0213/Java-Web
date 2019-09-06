
class Project{
	private String name;
	private String startDt;
	private String endDt;
	private String location;
	private Developer[] dev;
	private int count;
	
	Project(String name, String startDt,String endDt,String location){
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.location = location;
	}

	Project(String name, String startDt, String endDt, String location, Developer[] dev){
		this.name = name;
		this.startDt = startDt;
		this.endDt = endDt;
		this.location = location;
		this.dev = dev;
	}
	
	public void process() {  //:  ��� Project�´����� 4���� ������ ��ġ�� �ȴ�
		plan();
		design();
		develop();
	}
	public void plan() {
		System.out.println("Project �غ�");
	}
	public void join(Developer d) {
		if(dev == null) {
			dev = new Developer[10];
			dev[0]=d;
		}else {
			for(int i=0;i<dev.length;i++) {
				if(dev[i]!=null) {
					count++;
				}else {
					break;
				}
			}
			dev[count] = d;
		}
	}
	public void design() {
		System.out.println("�����۾�����");
	}
	public void develop() {
		System.out.println("�����۾�����");
	}
	
	
	public String getPeriod() {
		String period;
		String end = endDt.substring(0, 4);
		String start = startDt.substring(0, 4);
		int periodYear = Integer.parseInt(end)-Integer.parseInt(start);
		end = endDt.substring(4, 6);
		start = startDt.substring(4, 6);
		int periodMonth = Integer.parseInt(end)-Integer.parseInt(start);
		if(periodMonth<0) {
			periodYear --;
			periodMonth = 12 + periodMonth;
		}
		return periodYear+"�� "+periodMonth+"����";
		
	}
	public int getMMByDeveloper() { //�����ڵ��� �� �۾����� ��
		int sum=0;
		for(int i=0;i<dev.length;i++) {
			if(dev[i]==null) {
				break;
			}
			sum += dev[i].getPeriod();
		}
		return sum; 
	}
	
	public void printDeveloper() {
		for(int i=0; i<dev.length;i++) {
			if(dev[i]==null)
				return;
			if(dev[i] instanceof HighDeveloper) {
				HighDeveloper hdp = (HighDeveloper)dev[i];
				System.out.println("��ް����� : "+hdp.getName()+"\tƯ�� : "+hdp.getSpecialSkill());
			}else {
				System.out.println("�Ϲݰ����� : "+dev[i].getName());
			}
		}
	}
}

class HrProject extends Project{
	
	HrProject(String name, String startDt, String endDt, String location) {
		super(name, startDt, endDt, location);
	}
	
	HrProject(String name, String startDt, String endDt, String location, Developer[] dev) {
		super(name, startDt, endDt, location, dev);
	}
}

class Developer{
	private String name;
	private int period;
	Developer(String name, int period){
		this.name = name;
		this.period = period;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
}

class HighDeveloper extends Developer{
	private String specialSkill;
	
	HighDeveloper(String name, int period, String specialSkill) {
		super(name, period);
		this.specialSkill = specialSkill;
	}

	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}
}

public class test {

	public static void main(String[] args) {
		Developer[] dp = new Developer[10];
		dp[0] = new Developer("������", 12);
		dp[1] = new Developer("������", 6);
		dp[2] = new Developer("�ٴٴ�", 9);
		dp[3] = new HighDeveloper("����", 6, "java");
		dp[4] = new HighDeveloper("������", 18, "C#");
		
		
		Project pj = new Project("������Ʈ1", "20180101", "20190801", "location", dp);
		HighDeveloper extra = new HighDeveloper("����", 3, "c++"); //�߰�������
		
		pj.join(extra);// ���� �����ڵ鿡 extra������ �߰�
		pj.process();
		pj.printDeveloper();
		
		System.out.println("���� ���߱Ⱓ : "+pj.getPeriod());
		System.out.println("�� ������ ���� ��: "+pj.getMMByDeveloper()+"����"); 

	}

}
