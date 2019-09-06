package week02;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		//실습3: 사칙연산
				//입력: A값, B값, 연산자(+,-,*,/)
				//출력: 결과 = xxx
				//*오류처리 
				//-연산자에 +,-,*,/ 이외의 값이 입력 시 아래 메세지를 출력한다.
				//"잘못된 연산자를 입력하였습니다."
				Scanner sc = new Scanner(System.in);
				System.out.println("사칙연산을 수행하는 프로그램입니다.");
				while(true)
				{
					System.out.println("두수를 입력하세요.");
					int a = sc.nextInt();
					int b = sc.nextInt();
					String op;
					
					int result = 0;
					
					while(true)
					{
						System.out.println("연산자를 입력하세요.");
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
							System.out.println("잘못된 연산자를 입력하였습니다.다시 입력하시기 바랍니다. ");
						}
					}
					System.out.printf("%d %s %d = %d", a, op ,b, result);
					System.out.println();
				}

	}

}
