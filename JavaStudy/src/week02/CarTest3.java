package week02;

class Car{
	String color;
	String gearType;
	int door;
	
	Car()
	{
		this("White", "auto", 4);
	}
	
	Car(Car c) //�ڽ��� ��ü�� ���� �� ����.
	{
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	
	Car(String color, String gearType, int door)
	{
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	
	public boolean equals(Object obj)
	{
		//���������� �����ϰ� �ִ� �ν��Ͻ��� ����Ÿ���� �˾ƺ��� ���� instanceof �����ڸ� ���.
		//�ַ� ���ǹ��� ���Ǹ�
		//instanceof�� ���ʿ��� ���������� �����ʿ��� Ÿ��(Ŭ������)�� �ǿ����ڷ� ��ġ�Ѵ�.
		//������ ����� boolean���� true, false �� �ϳ��� ��ȯ�Ѵ�.
		if(obj != null && obj instanceof Car)
		{
			return (this.color==((Car)obj).color) && (this.gearType==((Car)obj).gearType) && (this.door==((Car)obj).door);
		}
		else
		{
			return false;
		}
	}
}

public class CarTest3 {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(c1); //c1�� ���纻 c2�� �����Ѵ�.
		System.out.println(c1.door);
		System.out.println(c2.door);
		System.out.println(c1.equals(c2)); //�ּҰ��� �ٸ�.
	}

}
