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
		System.out.println("�۸�");
	}
}

class Cat implements AnimalType{
	public void bark(){
		System.out.println("�߿�");
	}
}

public class homework3 {

	public static void main(String[] args) {
		//�ǽ�3:����¢��
		//Animal class�� �����Ѵ�.
		//�����ڷ� AnimalType�� �Ķ���ͷ� �޴´�.
		//bark() �޼��带 ���� ������ ¢�¼Ҹ��� ����Ѵ�:Dog�� �۸�, Cat�� �߿�
		//���� Dog�� Cat�� Ŭ������ �����ϴµ� ���� �߰��� �� �ִ�.
		Dog d = new Dog();
		Cat c = new Cat();
		Animal an = new Animal(d);
		an.getbark();
		Animal an2 = new Animal(c);
		an2.getbark();
	}

}
