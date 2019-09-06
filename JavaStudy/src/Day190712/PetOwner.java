package Day190712;

class Vet{ //수의사
	public void giveShot(Animal a) { //주사를 놓는다.
		a.makeNoise(); //동물마다 다른 비명소리를 지른다.
	}	
}

class Animal{
	//각 동물은 이 메소드를 Overriding한다.
	public void makeNoise() {
		
	}

	public void eat() {
		
	}
	
}

class Dog extends Animal{
	public void makeNoise() {
		System.out.println("멍멍");
	}
	
	public void eat() {
		System.out.println("사료를 먹는다.");
	}
}

class Cat extends Animal{
	public void makeNoise() {
		System.out.println("야옹");
	}
	
	public void eat() {
		System.out.println("참치캔을 먹는다.");
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
