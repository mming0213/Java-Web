package Day190712;

public class ExceptionEx7 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);//에러 발생하여 catch문으로 이동.
			System.out.println(4); //실행되지 않는다.
		}catch(ArithmeticException ae) {
			if(ae instanceof ArithmeticException) System.out.println("true");
			System.out.println("ArithmeticException");
		}catch(Exception e) {
			System.out.println("Exception");
		}//try-catch의 끝
		
		System.out.println(6);
	}//main 메서드의 끝

}
