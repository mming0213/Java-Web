package Day190711;

import java.util.Scanner;

public class FlowEx34 {

	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		String tmp;
		Scanner scanner = new Scanner(System.in);
		
		outer:
		while(true) 
		{
			System.out.println("(1)square");
			System.out.println("(2)square root");
			System.out.println("(3)log");
			System.out.println("���ϴ� �޴�(1~3)�� �����ϼ���.(����:0)>");
			
			tmp = scanner.nextLine();
			menu = Integer.parseInt(tmp);
			
			if(menu==0)
			{
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else if(!(1 <= menu && menu <=3))
			{
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�.(����� 0)");
				continue;
			}
		
			for(;;) 
			{
				System.out.println("����� ���� �Է��ϼ���.(��� ����:0, ��ü����:99)>");
				tmp = scanner.nextLine();
				num = Integer.parseInt(tmp);
				
				if(num == 0)
				{
					break;
				}
				if(num == 99) 
				{
					break outer; //��ü ����. for���� while���� ��� �����.
				}
				
				switch(menu)
				{
					case 1:
						System.out.println("result=" + num*num);
						break;
					case 2:
						System.out.println("result=" + Math.sqrt(num));
						break;
					case 3:
						System.out.println("result=" + Math.log(num));
						break;
				}
			}
			
			
		}
	}
}
