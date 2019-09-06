package Day190716;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
	public String str;
	public ReflectTest(String str) {
		this.str = str;
		System.out.println("REFLECT ������ ȣ��:" + str);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("data.ReflectTest");
		System.out.println(c); //Class�� ���
		Constructor[] ctor = c.getConstructors(); //�����ڸ� ��´�
		for(int i = 0; i < ctor.length; i++) {
			System.out.println("������:"+ctor[i].toString());
		}
		
		Method m[] = c.getMethods(); //�޼ҵ带 ��´�.
		for(int i = 0; i < m.length; i++) {
			System.out.println("�޼ҵ�:"+m[i].toString());
		}
		
		//
	}

}
