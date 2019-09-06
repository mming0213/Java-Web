package Day190719;

class Calculator{
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000); //2�ʰ� sleep
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

//��Ƽ ������ ���α׷������� ��������� ��ü�� �����ؼ� �۾��ؾ��ϴ� ��찡 ����.
//���� ��ü�� ����� �� 
//�����尡 ������� ��ü�� �ٸ� �����尡 ������ �� ������ �Ϸ��� ������ �۾��� ���������� ��ü�� 
//����� �ɾ �ٸ� �����尡 ����� �� ������ �ؾ��ؾ���.
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
