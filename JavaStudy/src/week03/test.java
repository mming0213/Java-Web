package week03;

class Parent{
	public String name = "K";
	public void test1() {
		System.out.println("AA");
	}
	public String getName(){
		return this.name;
	}
}

class Child extends Parent{
	public String name = "M";
	public void test1(){ //오버라이딩
		System.out.println("BB");
	}
	public void test2() {
		System.out.println("CC");
	}
	public String getName(){
		return this.name;
	}
}

public class test {

	public static void main(String[] args) {
		Child c = new Child();
		c.test1(); //BB
		c.test2(); //CC
		System.out.println(c.name);//M
		System.out.println(c.getName());//M
		
		Parent p = c;
		p.test1();//BB
		//p.test2();   //Error!
		System.out.println(p.name); //K
		System.out.println(p.getName());//M
	}

}
