package Day04;

class Father{
	String name;
	int age;
	String job;
	
	void goToWork(int time)
	{
		System.out.println(time + "�ÿ� ����ϴ�.");
	}
	void goOffWork(int time)
	{
		System.out.println(time + "�ÿ� ����ϴ�.");
	}
}

public class FatherTest {

	public static void main(String[] args) {
		//�ǽ�1: Father�� ���� Ŭ����
		Father f = new Father();
		f.goToWork(9);
		f.goOffWork(18);

	}

}
