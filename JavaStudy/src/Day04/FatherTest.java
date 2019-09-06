package Day04;

class Father{
	String name;
	int age;
	String job;
	
	void goToWork(int time)
	{
		System.out.println(time + "시에 출근하다.");
	}
	void goOffWork(int time)
	{
		System.out.println(time + "시에 퇴근하다.");
	}
}

public class FatherTest {

	public static void main(String[] args) {
		//실습1: Father에 대한 클래스
		Father f = new Father();
		f.goToWork(9);
		f.goOffWork(18);

	}

}
