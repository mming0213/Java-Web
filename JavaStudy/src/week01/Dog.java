package week01;

public class Dog {
	
	String name; //String�� �ʱⰪ�� null�̴�.

	public void bark()
	{
		//this.name = "";
		System.out.println(name + "�� ��! �ϰ� ¢���ϴ�.");
	}
	
	public void eat()
	{
		
	}
	
	public void chaseCat()
	{
		
	}
	
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name = "Bart";
		dog1.bark();
		
		//Dog �迭�� ����ϴ�.
		Dog[] myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		
		
		myDogs[0].name = "Fred";
		myDogs[1].name = "Marge";
		
		System.out.println("������ �������� �̸���:");
		System.out.println(myDogs[2].name);
		
		int x = 0;
		while(x < myDogs.length)
		{
			myDogs[x].bark();
			x = x+1;
		}
		
	}

}
