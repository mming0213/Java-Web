package week01;

class Box{
	public int x;
}

public class PassingValueType {

	void test01(int param)
	{
		param = 2;
	}
	
	void test02(Box box)
	{
		box = new Box();
		box.x = 1;
	}
	
	void test03(Box box)
	{
		box.x = 1;
	}
	
	public static void main(String[] args) {
		
		PassingValueType test = new PassingValueType();
		int iValue = 1;
		System.out.println("test01 before:" + iValue);
		test.test01(iValue);
		System.out.println("test01 after:" + iValue);
		
		Box box = new Box();
		System.out.println("test02 before:" + box.x);
		test.test02(box);
		System.out.println("test02 before:" + box.x );
		
		Box box2 = new Box();
		System.out.println("test03 before:" + box2.x);
		test.test03(box2);
		System.out.println("test03 before:" + box2.x );
	}

}
