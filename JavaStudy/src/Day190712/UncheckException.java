package Day190712;

class UnCheckTest {
	//처리가 불가능하거나 호출자에게 예외 처리 여부의 결정권을 주고자 할 경우 사용
	public void test() throws RuntimeException{
		char[] a = new char[2];
		a[0] = 'a';
		a[1] = 'b';
		a[2] = 'c';
	}

	public void test2() throws Exception{
		char[] a = new char[2];
		a[0] = 'a';
		a[1] = 'b';
		a[2] = 'c';
	}
}

public class UncheckException {

	public static void main(String[] args) {
		UnCheckTest uck = new UnCheckTest();
		uck.test();
		try {
			uck.test2();
		}catch(Exception e) {
			e.printStackTrace();
		}//ERROR 발생

	}

}
