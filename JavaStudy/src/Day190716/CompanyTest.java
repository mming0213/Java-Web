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
	
	//��̸� �߰�
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
	
	//��̸� ����
	public boolean delHobby(String hobby) {
		int idx = -1;
		//Arrays.copyOf(�����迭, ������ ����);
		String[] temp = Arrays.copyOf(this.hobby, this.hobby.length);
		
		try {
		for(int i = 0; i < this.hobbyCnt; i++)
		{
			if(this.hobby[i].equals(hobby)) {
				idx = i; //1
			}
		}
		//���� ��� ��̰� �������� �ʴ� ���
		if(idx < 0) {
			return false;
		}
		//�ش� index �����ϰ� ���ο� ��̹迭 �����
		for(int i = 0; i < this.hobbyCnt; i++)
		{
			if(i >= idx) //i = 0, 0 >= 1(x) 
			{
				this.hobby[i] = this.hobby[i+1];
			}
		}
		//���� ��� ��̰� �ִ� ��� ������ �� �ʱ�ȭ
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
	
	//���� �ٹ� ȸ����
	//����ٹ�ȸ�簡 ����Ǹ� historyCompany�� �̷��� �߰�
	public boolean setNotCompany(Company company) {
		if(this.nowCompany != company)
		{
			this.nowCompany = company;
			historyCompany[cnt++] = company;
			return true;
		}
		else return false;
	}
	
	//�� ȸ�� �ٹ��̷��� �Ⱓ ����
	public int getTotalPeriod() {
		int sum = 0;
		for(int i = 0; i < cnt; i++)
		{
			sum += historyCompany[i].getPeriod();
		}
		
		return sum;
	}
	
	//�ٹ��� ȸ�� ���
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
		
		Company cp1 = new Company("ȸ��1", 10);
		Company cp2 = new Company("ȸ��2", 7);
		Company cp3 = new Company("��Ʈ", 1);
//		
		CompanyMan cm = new CompanyMan("����", 25, cp3);
//		if(cm.setNotCompany(cp1)) {
//			cm.printHistoryCompany();
//			System.out.println(cm.getTotalPeriod());
//		}
//		
//		if(cm.setNotCompany(cp2)) {
//			cm.printHistoryCompany();
//			System.out.println(cm.getTotalPeriod());
//		}

		cm.setHobby("�״Ͻ�");
		cm.setHobby("����");
		cm.setHobby("Ź��");
		cm.setHobby("������");
		cm.printHobby();
		System.out.println("--------------------------");
		cm.delHobby("����");
		cm.delHobby("�״Ͻ�");
		cm.delHobby("�ȳ�");
		cm.printHobby();
		
		
//		Developer[] dp = new Developer[10];
//		dp[0] = new Developer("ȫ�浿", 10);
//		dp[1] = new Developer("��浿", 7);
//		dp[2] = new HighDeveloper("����", 5, "C#");
		
	}

}
