package week02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PayCal {

	public static void main(String[] args) {
		//�ǽ�2:�޿� ����ϱ�
				//-�Է�:�⺻��, ��å(���/�븮/����/����)
				//-���:�Ǽ��ɾ� = xxx��
				//*������ ������ ����.
				//�Ǽ��ɾ� = �⺻�� + ��å���� - ����
				//���� = �⺻���� 10%
				//*��ì ����ǥ
				//-����:200,000
				//-����:500,000
				
				Scanner sc = new Scanner(System.in);
				System.out.println("�⺻���� �Է��ϼ���.");
				int salary = sc.nextInt();
				System.out.println("��å(���/�븮/����/����)�� �Է��ϼ���.");
				String pos = sc.next();
				int extra = 0;
				
				while(true)
				{
					if(pos.equals("����"))
					{
						extra = 500000;
						break;
					}
					else if(pos.equals("����"))
					{
						extra = 200000;
						break;
					}
					else if(pos.equals("�븮") || pos.equals("���"))
					{
						extra = 0;
						break;
					}
					else
					{
						System.out.println("�߸��� ��å�� �Է��Ͽ����ϴ�.�ٽ� �Է��Ͻñ� �ٶ��ϴ�. ");
					}
				}
				
				int tax = (int) (salary * 0.1);
				int totalsalary = salary + extra - tax;
				DecimalFormat df = new DecimalFormat("###,###");
				String dftotal = df.format(totalsalary);
				System.out.println("�Ǽ��ɾ���  " + dftotal + "�� �Դϴ�.");
	}

}
