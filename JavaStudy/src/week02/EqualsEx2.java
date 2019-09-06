package week02;

class Person2{
	long id;
	public boolean equals(Object obj)
	{
		//���������� �����ϰ� �ִ� �ν��Ͻ��� ����Ÿ���� �˾ƺ��� ���� instanceof �����ڸ� ���.
		//�ַ� ���ǹ��� ���Ǹ�
		//instanceof�� ���ʿ��� ���������� �����ʿ��� Ÿ��(Ŭ������)�� �ǿ����ڷ� ��ġ�Ѵ�.
		//������ ����� boolean���� true, false �� �ϳ��� ��ȯ�Ѵ�.
		if(obj != null && obj instanceof Person2)
		{
			return id==((Person2)obj).id;
		}
		else
		{
			return false;
		}
	}
	
	Person2(long id)
	{
		this.id = id;
	}
}

public class EqualsEx2 {

	public static void main(String[] args) {
		Person2 p1 = new Person2(8022082222333L);
		Person2 p2 = new Person2(8022082222333L);
		
		if(p1==p2) //�ٸ���
		{
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		}
		else
		{
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		}
		
		if(p1.equals(p2)) //����. �����ǵǾ� ���ٰ� ǥ��
		{
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		}
		else
		{
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		}
	}

}
