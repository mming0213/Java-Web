package Day190712;

public class FinallyTest3 {

	static void method1(){
		try {
			System.out.println(0/0);
			System.out.println("method1()�� ȣ��Ǿ����ϴ�.");
			return; //���� ���� ���� �޼��带 �����Ѵ�.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("method1()�� finally���� ����Ǿ����ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		//method1()�� static �޼����̹Ƿ� �ν��Ͻ� �������� ���� ȣ��.
		FinallyTest3.method1();
		System.out.println("method1()�� ������ ��ġ�� main �޼���� ����.");
		//main �޼����� ��
		
	}

}
