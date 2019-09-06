package Day190711;

interface MyInterface{
	default void method1() {
		System.out.println("method1() int MyInterface");
	}

	default void method2(){
		System.out.println("method2() int MyInterface");
	}

	static void staticMethod() {
		System.out.println("statcMethod() in MyInterface");
	}
}

interface MyInterface2{
	default void method1() {
		System.out.println("method1() int MyInterface2");
	}
	
	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface2");
	}
}

class Parent{
	public void method2() {
		System.out.println("method2 int Parent");
	}
}

class Child extends Parent implements MyInterface, MyInterface2{
	public void method1() {
		System.out.println("method1() int Child"); //오버라이딩
	}
}


public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.method1();
		c.method2();
		MyInterface.staticMethod();
		MyInterface2.staticMethod();
	}

}
