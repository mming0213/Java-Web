
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
	
	public void process() {  //:  모든 Project는다음의 4가지 과정을 거치게 된다
		plan();
		design();
		develop();
	}
	public void plan() {
		System.out.println("Project 준비");
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
		System.out.println("설계작업수행");
	}
	public void develop() {
		System.out.println("개발작업수행");
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
		return periodYear+"년 "+periodMonth+"개월";
		
	}
	public int getMMByDeveloper() { //개발자들의 총 작업량의 합
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
				System.out.println("고급개발자 : "+hdp.getName()+"\t특기 : "+hdp.getSpecialSkill());
			}else {
				System.out.println("일반개발자 : "+dev[i].getName());
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
		dp[0] = new Developer("가가가", 12);
		dp[1] = new Developer("나나나", 6);
		dp[2] = new Developer("다다다", 9);
		dp[3] = new HighDeveloper("라라라", 6, "java");
		dp[4] = new HighDeveloper("마마마", 18, "C#");
		
		
		Project pj = new Project("프로젝트1", "20180101", "20190801", "location", dp);
		HighDeveloper extra = new HighDeveloper("사사사", 3, "c++"); //추가개발자
		
		pj.join(extra);// 기존 개발자들에 extra개발자 추가
		pj.process();
		pj.printDeveloper();
		
		System.out.println("현재 개발기간 : "+pj.getPeriod());
		System.out.println("총 개발자 월수 합: "+pj.getMMByDeveloper()+"개월"); 

	}

}
