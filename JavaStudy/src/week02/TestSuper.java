package week02;

class Employee1{
//	Employee1(){
//		System.out.println("나는 부모 constructor");
//	}
	
	Employee1(int a){
		System.out.println("나는 부모 constructor");
	}
}

class Manager extends Employee1{
	Manager()
	{
		super(1); //생략시 자동으로 생성된다.
		System.out.println("나는 자식 constructor");
	}
}

public class TestSuper {

	public static void main(String[] args) {
		Manager m = new Manager();

	}

}
