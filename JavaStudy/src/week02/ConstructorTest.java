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
		this();//생성자에서 다른 생성자 호출
		d = x;
		//this(x); //에러! 생성자 안에서 다른 생성자를 호출하려면 첫번쨰째 라인에서 호출해야한다.
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
