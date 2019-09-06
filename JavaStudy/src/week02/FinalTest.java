package week02;

final class Human{
	public void pro(){
		System.out.println("pro");
	}
}

//final 클래스는 상속 시 하위 클래스에서 final 메소드를 재정의 할 수 없게 해주므로 
//상위 클래스로 사용할 수 없다.
//class Student extends Human{
//	public void info() {
//		System.out.println("info");
//	}
//}

class Student{
	public void info() {
		System.out.println("info");
	}
}

public class FinalTest {

	public static void main(String[] args) {
		Student s = new Student();
		s.info();
	}

}
