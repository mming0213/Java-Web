package week03.iface;

interface interA1{
	int w = 10;
	static int x = 20;
	final int y = 30;
	public static final int z = 40;
}

public class InterfaceTest {

	public static void main(String[] args) {
		//interA1 ap = new interA1();//interface�� instance�� ������ �� ����
		//interA1.w = 100;//interface�� �ʵ�� public static final �̹Ƿ� ���� ���� �� �� ����.
		System.out.println("w = " + interA1.w);
		System.out.println("x = " + interA1.x);
		System.out.println("x = " + interA1.y);
		System.out.println("x = " + interA1.z);

	}

}
