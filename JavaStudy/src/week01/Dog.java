package week01;

public class Dog {
	
	String name; //String의 초기값은 null이다.

	public void bark()
	{
		//this.name = "";
		System.out.println(name + "이 왈! 하고 짖습니다.");
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
		
		//Dog 배열을 만듭니다.
		Dog[] myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		
		
		myDogs[0].name = "Fred";
		myDogs[1].name = "Marge";
		
		System.out.println("마지막 강아지의 이름은:");
		System.out.println(myDogs[2].name);
		
		int x = 0;
		while(x < myDogs.length)
		{
			myDogs[x].bark();
			x = x+1;
		}
		
	}

}
