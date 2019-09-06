package Day190719;

class ThreadB extends Thread{
	//�ش� �����尡 ����Ǹ� �ڱ� �ڽ��� ����͸� ���� ȹ��
	//5�� �ݺ��ϸ鼭 0.5�� ���鼭 total�� ���� ����
	//�� �Ŀ� notify()�޼ҵ带 ȣ���Ͽ� wait�ϰ� �ִ� �����带 ����.
	int total;
	@Override
	public void run() {
		synchronized(this) {
			for(int i = 0; i < 5; i++) {
				System.out.println(i + "�� ���մϴ�.");
				total += i;
				try {
					Thread.sleep(500); //0.5�� ���鼭
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			notify();
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		//�տ��� ���� ������ B�� ���� �� start
		//�ش� �����尡 ����Ǹ�, �ش� ������� run�޼ҵ� �ȿ��� �ڽ��� ����͸� ���� ȹ��
		ThreadB b = new ThreadB();
		b.start();
		//b�� ���Ͽ� ����ȭ ������ ����
		//���� main �����尡 wait�� �ϰ� �Ǹ鼭 main ������ ���
		synchronized(b) {
			try {
				//b.wait()�޼ҵ带 ȣ��.
				//���ξ������ ����
				//ThredB�� 5�� ���� ���� �� notify�� ȣ���ϰ� �Ǹ� wait���� ���.
				System.out.println("b�� �Ϸ�ɶ����� ��ٸ��ϴ�.");
				b.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			//��� �� ����� ���
			System.out.println("Total is:" + b.total);
		}
	}

}