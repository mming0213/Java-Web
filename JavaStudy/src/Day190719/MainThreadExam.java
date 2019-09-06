package Day190719;

class Calculator{
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000); //2초간 sleep
		}catch(Exception e) {
			
		}
		
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}
	
}

class User1 extends Thread{
	private Calculator calc;
	
	public void setCalculator(Calculator calc) {
		this.setName("calcUser1");
		this.calc = calc;
	}
	
	public void run() {
		calc.setMemory(100);
	}
}

class User2 extends Thread{
	private Calculator calc;
	
	public void setCalculator(Calculator calc) {
		this.setName("calcUser2");
		this.calc = calc;
	}
	
	public void run() {
		calc.setMemory(50);
	}
	
}

//멀티 스레드 프로그램에서는 스레드들이 객체를 공유해서 작업해야하는 경우가 있음.
//공유 객체을 사용할 때 
//스레드가 사용중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날때까지 객체에 
//잠금을 걸어서 다른 스레드가 사용할 수 없도록 해야해야함.
public class MainThreadExam {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calc);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calc);
		user2.start();
		

	}

}
