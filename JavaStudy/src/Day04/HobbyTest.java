package Day04;

interface Hobby{
	public String setHobby();
}

class Tennis implements Hobby{
	public String setHobby() {
		return "테니스";
	}
}

class Piano implements Hobby{
	public String setHobby() {
		return "피아노";
	}
}

class Parent{
	public String name;
	public int age;
	public Hobby hobby;
	
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
}

class Child extends Parent{
	Child(String name){
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Object obj)
	{
		if(obj != null && obj instanceof Child)
		{
			return name==((Child)obj).name;
		}
		else
		{
			return false;
		}
	}
	
	public String toString(){
		return hobby.setHobby();
	}
	
}

public class HobbyTest {

	public static void main(String[] args) {
		Child c = new Child("홍길동");
		Parent p = c;
		c.setAge(30);
		
		Tennis t = new Tennis();
		Hobby b = t;
		c.setHobby(t);
		
		Piano p2 = new Piano();
		Hobby b2 = p2;
		c.setHobby(p2);
		
		Child c2 = new Child("홍길동");
		System.out.println(c.age);
		System.out.println(c);//피아노
		System.out.println(c.equals(c2));

	}

}
