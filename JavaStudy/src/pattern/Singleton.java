package pattern;

public class Singleton {
	private Singleton() {} //private�̱� ������ �����ڸ� ���������.������� �ν��Ͻ�������!
	private static Singleton instance = null; //�������� �ν��Ͻ��� �ϳ��� �����ϰԲ� �����Ѱ�.
	public static synchronized Singleton getInstance() {//synchronized ����ȭ ��(�ϳ��� �����常 ������ �� ����.)
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
