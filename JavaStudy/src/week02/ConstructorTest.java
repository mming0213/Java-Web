package week02;

public class ConstructorTest {
	int a,b,c,d,e,f,g;
	ConstructorTest(){
		a = 1;
		b = 2;
		c = 3;
		d = 4;
		e = 5;
		f = 6;
		g = 7;
	}
	
	ConstructorTest(int x)
	{
		this();//�����ڿ��� �ٸ� ������ ȣ��
		d = x;
		//this(x); //����! ������ �ȿ��� �ٸ� �����ڸ� ȣ���Ϸ��� ù����° ���ο��� ȣ���ؾ��Ѵ�.
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}
	
	ConstructorTest(int x, int y){
		this(x);
		e = y;
		//System.out.println(e);
	}
	
	
	public static void main(String[] args) {
		ConstructorTest ex = new ConstructorTest();
		//ConstructorTest ex1 = new ConstructorTest(10);
		ConstructorTest ex2 = new ConstructorTest(20,30);
	}

}
