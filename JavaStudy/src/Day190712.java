
class Mother{
	public String name;
	public int age;
	public String job;
	private Child[] childs;
	
	Mother(){
	}
	
	Mother(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	Mother(String name, int age, String job, Child[] childs){
		this(name, age);
		this.job = job;
		this.childs = childs;
	}
	
	void goToSchool() {
		System.out.println("���̵�� �б�����.");
	}
	
	//���̵� ����ŭ ��� =>�������̸��������� ���ϴ�
	void callChild() {
		for(int i = 0; i < childs.length; i++)
		{
			System.out.println(childs[i].name + "�� ���� ���ϴ�.");
		}
	}
	
	//���̸� ����
	void setChild(Child[] c) {
		this.childs = c;
	}
	
}

class Child extends Mother{
	public String hobby;
	
	Child(){
	}
	
	Child(String name, int age) {
		super(name, age);
		
	}
	
	Child(String name, int age, String hobby){
		super(name, age);
		this.hobby = hobby;
	}
	
	void goToSchool() {
		System.out.println("�б�����");
	}
	
	void fight(Child c) {
		System.out.println(c.name + "�� �ο����ϴ�.");
	}
	
	
}

public class Day190712 {

	public static void main(String[] args) {
		Child[] c = {	new Child("����", 3),
						new Child("ö��", 5),
						new Child("�α�", 7, "�뷡�θ���"),
						};

		Mother m = new Mother("����", 30, "������", c);
		m.goToSchool(); //���̵�� �б�����.
		m.setChild(c);
		m.callChild();
		
//		System.out.println(m.name);
//		System.out.println(m.age);
//		System.out.println(m.job);
		
		

		
		
		
		
					

	}

}
