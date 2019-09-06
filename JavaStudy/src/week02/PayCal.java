package week02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PayCal {

	public static void main(String[] args) {
		//실습2:급여 계산하기
				//-입력:기본급, 직책(사원/대리/과장/부장)
				//-출력:실수령액 = xxx원
				//*계산식은 다음과 같다.
				//실수령액 = 기본급 + 직책수당 - 세금
				//세금 = 기본급의 10%
				//*직챙 수당표
				//-과장:200,000
				//-부장:500,000
				
				Scanner sc = new Scanner(System.in);
				System.out.println("기본급을 입력하세요.");
				int salary = sc.nextInt();
				System.out.println("직책(사원/대리/과장/부장)을 입력하세요.");
				String pos = sc.next();
				int extra = 0;
				
				while(true)
				{
					if(pos.equals("부장"))
					{
						extra = 500000;
						break;
					}
					else if(pos.equals("과장"))
					{
						extra = 200000;
						break;
					}
					else if(pos.equals("대리") || pos.equals("사원"))
					{
						extra = 0;
						break;
					}
					else
					{
						System.out.println("잘못된 직책을 입력하였습니다.다시 입력하시기 바랍니다. ");
					}
				}
				
				int tax = (int) (salary * 0.1);
				int totalsalary = salary + extra - tax;
				DecimalFormat df = new DecimalFormat("###,###");
				String dftotal = df.format(totalsalary);
				System.out.println("실수령액은  " + dftotal + "원 입니다.");
	}

}
