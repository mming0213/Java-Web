package week01;

import java.util.Scanner;

public class GradeCalcTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� = ");
		int kor = sc.nextInt();
		
		System.out.println("���� = ");
		int eng = sc.nextInt();
		
		System.out.println("���� = ");
		int math = sc.nextInt();
		
		int total = kor + eng + math;
		double avg = total/3.0f;
		System.out.printf("����: %d��\n", total);
		System.out.printf("���:%.2f��\n", avg);

	}

}
