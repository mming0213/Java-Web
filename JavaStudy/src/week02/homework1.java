package week02;
//실습1:일반화,추상화
	//1.일반화 객체:Person, Animal
	//Person
	//-속성: 이름, 성별, 나이, 직업, 혈액형, 인종...
	//-메서드: 말하다(추), 먹는다, 입는다, 걷는다, ...
	
	//Animal
	//- 속성: 종, 서식지, 다리 개수, 암수 ...
	//- 메서드: 소리내다, 걷다, 사냥한다...  
	
	//2.추상화 객체:
	//Person, Animal의 추상화 객체
	
	//Person : 인종, 국가, 언어, 직업, 혈액형... 
	//Animal : 걷는 방식(두발,네발), 소리(왈왈, 야옹), ... 

abstract class Person{
	String name;
	int gender;
	int age;
	boolean live;
	
	abstract void speak();
}

class Korean extends Person{
	void speak()
	{
		System.out.println(name + "는 한국사람이고 한국어를 한다.");
	}
}

class American extends Person{
	void speak()
	{
		System.out.println(name + "는 미국사람이고 영어를 한다.");
	}
}

class Japanese extends Person{
	void speak()
	{
		System.out.println(name + "는 일본사람이고 일본어를 한다.");
	}
}

abstract class Animal{
	abstract void move(); 
	
	abstract void speak(); 
	
	void stop()
	{
		
	} 
}

class Dog2 extends Animal{
	void move()
	{
		System.out.println("네발로 걸어서 이동");
	}
	
	void speak() 
	{
		System.out.println("왈왈");
	}
}

class Cat extends Animal{
	void move()
	{
		System.out.println("네발로 걸어서 이동");
	}
	void speak() 
	{
		System.out.println("야옹");
	}

}

public class homework1 {
	
	public static void main(String[] args) {
		//실습1:일반화,추상화
		//1.일반화 객체:Person, Animal
		//Person
		//-속성: 이름, 성별, 나이, 직업, 혈액형, 인종...
		//-메서드: 말하다(추), 먹는다, 입는다, 걷는다, ...
		
		//Animal
		//- 속성: 종, 서식지, 다리 개수, 암수 ...
		//- 메서드: 소리내다, 걷다, 사냥한다...  
		
		//2.추상화 객체:
		//Person, Animal의 추상화 객체
		
		//Person : 인종, 국가, 언어, 직업, 혈액형... 
		//Animal : 걷는 방식(두발,네발), 소리(왈왈, 야옹), ... 

		
		Korean kor = new Korean();
		kor.name = "홍길동";
		kor.speak();
		
		American ame = new American();
		ame.name = "Mike";
		ame.speak();
		
		Japanese jap = new Japanese();
		jap.name = "Jun";
		jap.speak();
		
		Dog2 dg = new Dog2();
		dg.move();
		dg.speak();

		Cat cat = new Cat();
		cat.move();
		cat.speak();
		
	}

}
