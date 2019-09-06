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
		System.out.println("물 끓이는 중");
	}
	void pourlnCup() {
		System.out.println("컵에 따르는 중");
	}
}

class Coffee extends CaffeineReferager1{
	void brew(){
		System.out.println("필터를 통해 커피를 우려내는 중");
	}
	void addcndiments() {
		System.out.println("설탕과 우유를 추가하는 중");
	}
}

class Tee extends CaffeineReferager1{
	void brew(){
		System.out.println("차를 우려내는 중");
	}
	void addcndiments() {
		System.out.println("레몬을 추가하는 중");
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