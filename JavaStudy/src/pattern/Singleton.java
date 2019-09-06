package pattern;

public class Singleton {
	private Singleton() {} //private이기 때문에 생성자를 만들수없음.마음대로 인스턴스하지마!
	private static Singleton instance = null; //힙영역에 인스턴스가 하나만 존재하게끔 구현한것.
	public static synchronized Singleton getInstance() {//synchronized 동기화 블럭(하나의 쓰레드만 실행할 수 있음.)
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
