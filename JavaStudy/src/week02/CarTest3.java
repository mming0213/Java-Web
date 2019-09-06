package week02;

class Car{
	String color;
	String gearType;
	int door;
	
	Car()
	{
		this("White", "auto", 4);
	}
	
	Car(Car c) //자신의 객체를 받을 수 있음.
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
		//참조변수가 참조하고 있는 인스턴스의 실제타입을 알아보기 위해 instanceof 연산자를 사용.
		//주로 조건문에 사용되며
		//instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자로 위치한다.
		//연산의 결과로 boolean값인 true, false 중 하나를 반환한다.
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
		Car c2 = new Car(c1); //c1의 복사본 c2를 생성한다.
		System.out.println(c1.door);
		System.out.println(c2.door);
		System.out.println(c1.equals(c2)); //주소값이 다름.
	}

}
