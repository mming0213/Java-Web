package Day190712;

class UnCheckTest {
	//ó���� �Ұ����ϰų� ȣ���ڿ��� ���� ó�� ������ �������� �ְ��� �� ��� ���
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
		}//ERROR �߻�

	}

}
