package week02;

class Person2{
	long id;
	public boolean equals(Object obj)
	{
		//참조변수가 참조하고 있는 인스턴스의 실제타입을 알아보기 위해 instanceof 연산자를 사용.
		//주로 조건문에 사용되며
		//instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자로 위치한다.
		//연산의 결과로 boolean값인 true, false 중 하나를 반환한다.
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
		
		if(p1==p2) //다르다
		{
			System.out.println("p1과 p2는 같은 사람입니다.");
		}
		else
		{
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		if(p1.equals(p2)) //같다. 재정의되어 같다고 표시
		{
			System.out.println("p1과 p2는 같은 사람입니다.");
		}
		else
		{
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}

}
