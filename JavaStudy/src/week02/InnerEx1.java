package week02;

public class InnerEx1 {
	int m = 3;
	class InstanceInner{
		int iv = 100;
		int t = m;
		//static int cv = 100; //에러!static 변수를 선언할 수 없다.
		final static int CONST = 100; 
	}
	static class StaticInner{
		int iv = 200;
		//int t = m; //에러!
		static int cv = 200; //static 클래스만 static 멤버를 정의할 수 있다.
	}
	void myMethod()
	{
		class Locallnner{
			int iv = 300;
			int t = m;
			//static int cv = 300; //에러! static 변수를 선언할 수 없다.
			final static int CONST = 300; //final static은 상수이므로 허용.
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
