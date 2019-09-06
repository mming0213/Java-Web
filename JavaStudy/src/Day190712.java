
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
		System.out.println("아이들과 학교가다.");
	}
	
	//아이들 수만큼 출력 =>‘아이이름’이지금 갑니다
	void callChild() {
		for(int i = 0; i < childs.length; i++)
		{
			System.out.println(childs[i].name + "가 지금 갑니다.");
		}
	}
	
	//아이를 설정
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
		System.out.println("학교가다");
	}
	
	void fight(Child c) {
		System.out.println(c.name + "과 싸웠습니다.");
	}
	
	
}

public class Day190712 {

	public static void main(String[] args) {
		Child[] c = {	new Child("영희", 3),
						new Child("철수", 5),
						new Child("민규", 7, "노래부르기"),
						};

		Mother m = new Mother("수영", 30, "개발자", c);
		m.goToSchool(); //아이들과 학교가다.
		m.setChild(c);
		m.callChild();
		
//		System.out.println(m.name);
//		System.out.println(m.age);
//		System.out.println(m.job);
		
		

		
		
		
		
					

	}

}
