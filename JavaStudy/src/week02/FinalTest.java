package week02;

final class Human{
	public void pro(){
		System.out.println("pro");
	}
}

//final Ŭ������ ��� �� ���� Ŭ�������� final �޼ҵ带 ������ �� �� ���� ���ֹǷ� 
//���� Ŭ������ ����� �� ����.
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
