package week03;

interface AnimalType{
	
	public void bark();
}

class Animal{
	public AnimalType type;
	
	Animal(AnimalType type){
		this.type = type;
	}
	
	public void getbark() {
		type.bark();
	}
}

class Dog implements AnimalType{
	public void bark(){
		System.out.println("멍멍");
	}
}

class Cat implements AnimalType{
	public void bark(){
		System.out.println("야옹");
	}
}

public class homework3 {

	public static void main(String[] args) {
		//실습3:동물짖기
		//Animal class를 설계한다.
		//생성자로 AnimalType을 파라미터로 받는다.
		//bark() 메서드를 통해 동물의 짖는소리를 출력한다:Dog는 멍멍, Cat은 야옹
		//현재 Dog와 Cat의 클래스만 존재하는데 향후 추가될 수 있다.
		Dog d = new Dog();
		Cat c = new Cat();
		Animal an = new Animal(d);
		an.getbark();
		Animal an2 = new Animal(c);
		an2.getbark();
	}

}
