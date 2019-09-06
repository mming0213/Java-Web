package Day190716;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
	public String str;
	public ReflectTest(String str) {
		this.str = str;
		System.out.println("REFLECT 생성자 호출:" + str);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("data.ReflectTest");
		System.out.println(c); //Class명 출력
		Constructor[] ctor = c.getConstructors(); //생성자를 얻는다
		for(int i = 0; i < ctor.length; i++) {
			System.out.println("생성자:"+ctor[i].toString());
		}
		
		Method m[] = c.getMethods(); //메소드를 얻는다.
		for(int i = 0; i < m.length; i++) {
			System.out.println("메소드:"+m[i].toString());
		}
		
		//
	}

}
