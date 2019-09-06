package week02;
//�ǽ�1:�Ϲ�ȭ,�߻�ȭ
	//1.�Ϲ�ȭ ��ü:Person, Animal
	//Person
	//-�Ӽ�: �̸�, ����, ����, ����, ������, ����...
	//-�޼���: ���ϴ�(��), �Դ´�, �Դ´�, �ȴ´�, ...
	
	//Animal
	//- �Ӽ�: ��, ������, �ٸ� ����, �ϼ� ...
	//- �޼���: �Ҹ�����, �ȴ�, ����Ѵ�...  
	
	//2.�߻�ȭ ��ü:
	//Person, Animal�� �߻�ȭ ��ü
	
	//Person : ����, ����, ���, ����, ������... 
	//Animal : �ȴ� ���(�ι�,�׹�), �Ҹ�(�п�, �߿�), ... 

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
		System.out.println(name + "�� �ѱ�����̰� �ѱ�� �Ѵ�.");
	}
}

class American extends Person{
	void speak()
	{
		System.out.println(name + "�� �̱�����̰� ��� �Ѵ�.");
	}
}

class Japanese extends Person{
	void speak()
	{
		System.out.println(name + "�� �Ϻ�����̰� �Ϻ�� �Ѵ�.");
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
		System.out.println("�׹߷� �ɾ �̵�");
	}
	
	void speak() 
	{
		System.out.println("�п�");
	}
}

class Cat extends Animal{
	void move()
	{
		System.out.println("�׹߷� �ɾ �̵�");
	}
	void speak() 
	{
		System.out.println("�߿�");
	}

}

public class homework1 {
	
	public static void main(String[] args) {
		//�ǽ�1:�Ϲ�ȭ,�߻�ȭ
		//1.�Ϲ�ȭ ��ü:Person, Animal
		//Person
		//-�Ӽ�: �̸�, ����, ����, ����, ������, ����...
		//-�޼���: ���ϴ�(��), �Դ´�, �Դ´�, �ȴ´�, ...
		
		//Animal
		//- �Ӽ�: ��, ������, �ٸ� ����, �ϼ� ...
		//- �޼���: �Ҹ�����, �ȴ�, ����Ѵ�...  
		
		//2.�߻�ȭ ��ü:
		//Person, Animal�� �߻�ȭ ��ü
		
		//Person : ����, ����, ���, ����, ������... 
		//Animal : �ȴ� ���(�ι�,�׹�), �Ҹ�(�п�, �߿�), ... 

		
		Korean kor = new Korean();
		kor.name = "ȫ�浿";
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
