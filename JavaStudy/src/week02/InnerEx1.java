package week02;

public class InnerEx1 {
	int m = 3;
	class InstanceInner{
		int iv = 100;
		int t = m;
		//static int cv = 100; //����!static ������ ������ �� ����.
		final static int CONST = 100; 
	}
	static class StaticInner{
		int iv = 200;
		//int t = m; //����!
		static int cv = 200; //static Ŭ������ static ����� ������ �� �ִ�.
	}
	void myMethod()
	{
		class Locallnner{
			int iv = 300;
			int t = m;
			//static int cv = 300; //����! static ������ ������ �� ����.
			final static int CONST = 300; //final static�� ����̹Ƿ� ���.
		}
	}
	

	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		InnerEx1 t = new InnerEx1();
		InnerEx1.InstanceInner i = t.new InstanceInner();
		System.out.println(i.t);
		System.out.println(StaticInner.cv);

	}

}
