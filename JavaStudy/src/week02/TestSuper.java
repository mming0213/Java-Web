package week02;

class Employee1{
//	Employee1(){
//		System.out.println("���� �θ� constructor");
//	}
	
	Employee1(int a){
		System.out.println("���� �θ� constructor");
	}
}

class Manager extends Employee1{
	Manager()
	{
		super(1); //������ �ڵ����� �����ȴ�.
		System.out.println("���� �ڽ� constructor");
	}
}

public class TestSuper {

	public static void main(String[] args) {
		Manager m = new Manager();

	}

}
