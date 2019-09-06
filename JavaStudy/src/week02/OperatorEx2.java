package week02;

public class OperatorEx2 {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.println("abc" == "abc"); //true
		System.out.println(str1 == "abc"); //true
		System.out.println(str2 == "abc"); //false
		System.out.println(str1.equals("abc")); //true
		System.out.println(str2.equals("abc")); //true
		System.out.println(str2.equals("ABC")); //false
		//equalsIgnoreCase() : 대문자를 구분하지 않고 비교
		System.out.println(str2.equalsIgnoreCase("ABC")); //true
		
	}

}
