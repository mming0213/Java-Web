package week01;

//�������� ���� Ŭ������ �����ϰ� ��Ȳ�� ���� �޶����� ���� ����ڰ� �����ϰ� ��.
abstract class Calculator{
	int left, right;
	public void setOperands(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	int _sum()
	{
		return this.left + this.right;
	}
	public abstract void sum();
	public abstract void avg();
	public void run()
	{
		sum();
		avg();
	}
}


public class test {

	public static void main(String[] args) {
		//Calculator c1 = new Calculator();
		//c1.setOperands(10, 20);
		//c1.run();


	}

}
