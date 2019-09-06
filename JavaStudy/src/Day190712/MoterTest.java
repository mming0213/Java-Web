package Day190712;

class Mother{
	public String name;
	public int age;
	public String job;
	private Child[] childs;
	Child c;
	
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
	
	public void goToSchool() {
		System.out.println("���̵�� �б�����.");
	}
	
	//���̵� ����ŭ ��� =>�������̸��������� ���ϴ�
	public void callChild() {
		for(int i = 0; i < childs.length; i++)
		{
			System.out.println(childs[i].name + "�� ���� ���ϴ�.");
		}
	}
	
	
	public Child[] getChild() {
		return childs;
	}
	
	
	//���̸� ����
	public void setChild(Child[] c) {
		this.childs = c;
	}
	
}

class Child{
	String name;
	int age;
	public String hobby;
	
	
	Child(){
	}
	
	Child(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	Child(String name, int age, String hobby){
		this(name, age);
		this.hobby = hobby;
	}
	
	public void goToSchool() {
		System.out.println("�б�����");
	}
	
	public void fight(Child c) {
		System.out.println(c.name + "�� �ο����ϴ�.");
	}
	
}

public class MoterTest{

	public static void main(String[] args) {
//		Child[] c1 = new Child[3];
//		c1[0] = new Child("����", 3);
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
