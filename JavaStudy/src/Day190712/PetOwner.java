package Day190712;

class Vet{ //���ǻ�
	public void giveShot(Animal a) { //�ֻ縦 ���´�.
		a.makeNoise(); //�������� �ٸ� ���Ҹ��� ������.
	}	
}

class Animal{
	//�� ������ �� �޼ҵ带 Overriding�Ѵ�.
	public void makeNoise() {
		
	}

	public void eat() {
		
	}
	
}

class Dog extends Animal{
	public void makeNoise() {
		System.out.println("�۸�");
	}
	
	public void eat() {
		System.out.println("��Ḧ �Դ´�.");
	}
}

class Cat extends Animal{
	public void makeNoise() {
		System.out.println("�߿�");
	}
	
	public void eat() {
		System.out.println("��ġĵ�� �Դ´�.");
	}
	
	
}

public class PetOwner {

	public static void main(String[] args) {
		Animal[] animals = new Animal[2];
		animals[0] = new Dog();
		animals[1] = new Cat();
		for(int i = 0; i < animals.length; i++) {
			animals[i].eat();
		}
	
		Vet v = new Vet();
		Dog d = new Dog();
		Cat c = new Cat();
		v.giveShot(d);
		v.giveShot(c);
		

	}

}
