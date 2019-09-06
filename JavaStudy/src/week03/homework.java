package week03;

//실습1:일반화, 추상화
//1.Transformation:교통통합시스템
//-속성:이름, 평균속도, 이동수단(차,비행기,..),이동거리...  
//-메소드:이동하다(추), 멈춘다, ...
//2.Food:배달
//- 속성: 주문자, 배달음식, 배달자, 음식점,...
//- 메소드: 배달하다, 주문하다, ...
//3.Transformation 추상화 : 경적소리, 이동수단...
//4.Food 추상화: 운송수단, 주문방법(전화,앱..)...

//abstract class Animal{
//	public String AnimalType;
//	
//	Animal(String AnimaType)
//	{
//		this.AnimalType = AnimalType;
//	}
//	
//	public abstract void bark();
//}
//
//class Dog extends Animal{
//	public void bark(){
//		System.out.println("멍멍");
//	}
//}
//
//class Cat extends Animal{
//	public void bark() {
//		System.out.println("야옹");
//	}
//}

public class homework {
	
	public static void main(String[] args) {
		//실습3:동물짖기
		//Animal class를 설계한다.
		//생성자로 AnimalType을 파라미터로 받는다.
		//bark() 메서드를 통해 동물의 짖는소리를 출력한다:Dog는 멍멍, Cat은 야옹
		//현재 Dog와 Cat의 클래스만 존재하는데 향후 추가될 수 있다.
		
//		Dog d = new Dog();
//		Cat c = new Cat();
//		d.bark();
//		c.bark();
	}

}
