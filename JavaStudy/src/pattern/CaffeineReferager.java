package pattern;

abstract class CaffeineReferager1 {
	final void prepareRecipe() {
		this.boilWater();
		this.brew();
		this.pourlnCup();
		this.addcndiments();
	}
	
	abstract void brew();
	abstract void addcndiments();
	void boilWater() {
		System.out.println("�� ���̴� ��");
	}
	void pourlnCup() {
		System.out.println("�ſ� ������ ��");
	}
}

class Coffee extends CaffeineReferager1{
	void brew(){
		System.out.println("���͸� ���� Ŀ�Ǹ� ������� ��");
	}
	void addcndiments() {
		System.out.println("������ ������ �߰��ϴ� ��");
	}
}

class Tee extends CaffeineReferager1{
	void brew(){
		System.out.println("���� ������� ��");
	}
	void addcndiments() {
		System.out.println("������ �߰��ϴ� ��");
	}
}

public class CaffeineReferager {
	
	public static void main(String[] args) {
		Coffee c = new Coffee();
		c.prepareRecipe();
		
		Tee t = new Tee();
		t.prepareRecipe();
		
		
	}
}