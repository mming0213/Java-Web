package week01;

import java.util.Scanner;

public class GradeCalcTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 = ");
		int kor = sc.nextInt();
		
		System.out.println("영어 = ");
		int eng = sc.nextInt();
		
		System.out.println("수학 = ");
		int math = sc.nextInt();
		
		int total = kor + eng + math;
		double avg = total/3.0f;
		System.out.printf("총점: %d점\n", total);
		System.out.printf("평균:%.2f점\n", avg);

	}

}
