package week01;

public class VarArgsEx {

	static String concatenate(String delim, String...args)
	{
		String result = "";
		
		for(String str:args)
		{
			result += str + delim;
		}
		
		return result;
	}
	//가변인자 : 타입...변수명
	//가변인자는 항상 마지막 매개변수
	public static void main(String[] args) {
		String[] strArr = {"100","200","300"};
		
		System.out.println(concatenate("","100","200","300"));
		System.out.println(concatenate("-",strArr));
		System.out.println(concatenate(",",new String[] {"1","2","3"}));
		System.out.println("[" + concatenate(",",new String[0]+"]"));
		System.out.println("["+ concatenate(",")+"]");

	}

}
