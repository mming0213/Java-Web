package week02;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		//�ǽ�3: ��Ģ����
				//�Է�: A��, B��, ������(+,-,*,/)
				//���: ��� = xxx
				//*����ó�� 
				//-�����ڿ� +,-,*,/ �̿��� ���� �Է� �� �Ʒ� �޼����� ����Ѵ�.
				//"�߸��� �����ڸ� �Է��Ͽ����ϴ�."
				Scanner sc = new Scanner(System.in);
				System.out.println("��Ģ������ �����ϴ� ���α׷��Դϴ�.");
				while(true)
				{
					System.out.println("�μ��� �Է��ϼ���.");
					int a = sc.nextInt();
					int b = sc.nextInt();
					String op;
					
					int result = 0;
					
					while(true)
					{
						System.out.println("�����ڸ� �Է��ϼ���.");
						op = sc.next();
						if(op.equals("+"))
						{
							result = a+b;
							break;
						}
						else if(op.equals("-"))
						{
							result = a-b;
							break;
						}
						else if(op.equals("*"))
						{
							result = a*b;
							break;
						}
						else if(op.equals("/"))
						{
							result = a/b;
							break;
						}
						else
						{
							System.out.println("�߸��� �����ڸ� �Է��Ͽ����ϴ�.�ٽ� �Է��Ͻñ� �ٶ��ϴ�. ");
						}
					}
					System.out.printf("%d %s %d = %d", a, op ,b, result);
					System.out.println();
				}

	}

}
