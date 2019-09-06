package Classdiagram;


class Hobby{
	private String name;
	
	Hobby(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}

class Tennis extends Hobby{
	Tennis(){
		super("테니스");
	}
}

class Piano extends Hobby{
	Piano(){
		super("피아노");
	}
}

class Parent{
	public String name;
	public int age;
	public Hobby hobby;
	
	Parent(String name){
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	public boolean equals(Object obj)
	{
		if(obj != null && obj instanceof Child)
		{
			return name==((Parent)obj).name;
		}
		else
		{
			return false;
		}
	}
	
	public String toString(){
		return hobby.getName();
	}
}

class Child extends Parent{
	Child(String name){
		super(name);
	}

	
}

public class HobbyTest2 {

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
		
		System.out.println(c);//피아노
		System.out.println(c.equals(c2)); //true
		

	}

}
