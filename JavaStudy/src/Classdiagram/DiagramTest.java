package Classdiagram;

interface Race{
	public String getRace();
	
}

//person�� �ν��Ͻ�ȭ ����� �ƴϾ�! abstract ����.
//abstract class Person implements Race{
class Person implements Race{
	public String name;
	public int age;
	//public String animal;
	Animal[] animal = new Animal[3];

	Person(){
	}
	
	Person(Animal[] animal)
	{
		this.animal = animal;
	}
	
	Person(Animal a1, Animal a2, Animal a3)
	{
		animal[0] = a1;
		animal[1] = a2;
		animal[2] = a3;
		
	}

	public void speak() {
		System.out.println("���Ѵ�.");
	}

	@Override
	public String getRace() {
		return "����";
	}
}

class Animal {
	public String name;
	public String type;
	
	Animal(String name, String type)
	{
		this.name = name;
		this.type = type;
	}
	
	Animal(){
		this(null, null);
	}
	
}

class KoreanPerson extends Person{
	@Override
	public void speak() {
		System.out.println("�ѱ�� ���Ѵ�.");
	}
}

class JapanPerson extends Person{
	@Override
	public void speak() {
		System.out.println("�Ϻ�� ���Ѵ�.");
	}
}

public class DiagramTest {

	public static void main(String[] args) {
		Race r = new Person();
		System.out.println(r.getRace());
		
		Animal[] a = {	new Animal("����","������"),
						new Animal("����","�����"),
						new Animal("����","�޹���")
						};
		
		Person p = new Person(a);
		System.out.println(a[0].name + " " + a[1].name + " " + a[2].name);
		System.out.println(a[0].type+ " " + a[1].type + " " + a[2].type);
	}

}
