package Day190716;

import java.util.Arrays;

class CompanyMan{
	private String name;
	private int age;
	private String[] hobby = new String[5];
	private Company nowCompany;
	private Company[] historyCompany = new Company[5];
	private int cnt = 0;
	private int hobbyCnt = 0;
	
	CompanyMan(String name, int age, Company nowCompany){
		this.name = name;
		this.age = age;
		this.nowCompany = nowCompany;
	}
	
	//취미를 추가
	public boolean setHobby(String hobby) {
		int temp = hobbyCnt;
		try {
		this.hobby[this.hobbyCnt++] = hobby;
		}catch(Exception e) {
			hobbyCnt = temp;
			return false;
		}
		return true;
	}
	
	//취미를 삭제
	public boolean delHobby(String hobby) {
		int idx = -1;
		//Arrays.copyOf(원본배열, 복사할 길이);
		String[] temp = Arrays.copyOf(this.hobby, this.hobby.length);
		
		try {
		for(int i = 0; i < this.hobbyCnt; i++)
		{
			if(this.hobby[i].equals(hobby)) {
				idx = i; //1
			}
		}
		//삭제 대상 취미가 존재하지 않는 경우
		if(idx < 0) {
			return false;
		}
		//해당 index 제외하고 새로운 취미배열 만들기
		for(int i = 0; i < this.hobbyCnt; i++)
		{
			if(i >= idx) //i = 0, 0 >= 1(x) 
			{
				this.hobby[i] = this.hobby[i+1];
			}
		}
		//삭제 대상 취미가 있는 경우 마지막 값 초기화
		this.hobby[this.hobbyCnt-1] = null;
		}catch(Exception e) {
			this.hobby = temp;
			return false;
		}
		
		this.hobbyCnt--;
		return true;
	}
	
	public void printHobby() {
		for(int i = 0; i < this.hobbyCnt; i++)
		{
			System.out.println(hobby[i]);
		}
	}
	
	//현재 근무 회사등록
	//현재근무회사가 변경되면 historyCompany에 이력을 추가
	public boolean setNotCompany(Company company) {
		if(this.nowCompany != company)
		{
			this.nowCompany = company;
			historyCompany[cnt++] = company;
			return true;
		}
		else return false;
	}
	
	//총 회사 근무이력의 기간 리턴
	public int getTotalPeriod() {
		int sum = 0;
		for(int i = 0; i < cnt; i++)
		{
			sum += historyCompany[i].getPeriod();
		}
		
		return sum;
	}
	
	//근무한 회사 출력
	public void printHistoryCompany() 	{
		for(int i = 0; i < cnt; i++)
		{
			System.out.println(historyCompany[i].getName());
		}
	
	}
}

class Company{
	private String name;
	private int period;
	
	Company(String name, int period){
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

public class CompanyTest {

	public static void main(String[] args) {
		
		Company cp1 = new Company("회사1", 10);
		Company cp2 = new Company("회사2", 7);
		Company cp3 = new Company("비트", 1);
//		
		CompanyMan cm = new CompanyMan("민주", 25, cp3);
//		if(cm.setNotCompany(cp1)) {
//			cm.printHistoryCompany();
//			System.out.println(cm.getTotalPeriod());
//		}
//		
//		if(cm.setNotCompany(cp2)) {
//			cm.printHistoryCompany();
//			System.out.println(cm.getTotalPeriod());
//		}

		cm.setHobby("테니스");
		cm.setHobby("수영");
		cm.setHobby("탁구");
		cm.setHobby("배드민턴");
		cm.printHobby();
		System.out.println("--------------------------");
		cm.delHobby("수영");
		cm.delHobby("테니스");
		cm.delHobby("안녕");
		cm.printHobby();
		
		
//		Developer[] dp = new Developer[10];
//		dp[0] = new Developer("홍길동", 10);
//		dp[1] = new Developer("김길동", 7);
//		dp[2] = new HighDeveloper("영희", 5, "C#");
		
	}

}
