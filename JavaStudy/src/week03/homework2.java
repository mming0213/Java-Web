package week03;

import java.util.Arrays;
import java.util.Scanner;

class ArrayMove{
	int[] irr;
	int move;
	
	ArrayMove(int move, int[] irr)
	{
		this.move = move;
		this.irr = irr;
		arraymovefun();
	}
	
	void arraymovefun() {
		for(int k = 0; k < move; k++)
		{
			int temp = irr[0];
			for(int i = 0; i < irr.length-1; i++)
			{
				irr[i] = irr[i+1];
			}
			irr[irr.length-1] = temp;
		}
	}
	
	public String toString()
	{
		return Arrays.toString(irr);
	}

}

public class homework2 {

	public static void main(String[] args) {
		//실습2: 배열원소 이동
		//-입력: 1~10
		//-출력:[2,3,4,5,6,7,1]
		int[] irr = {1,2,3,4,5,6,7};
		Scanner sc = new Scanner(System.in);
		System.out.println("1~10까지 이동할 횟수를 입력해주세요.");
		int move = sc.nextInt();
		ArrayMove am = new ArrayMove(move, irr);
		System.out.println(am);
		
//		for(int i = 0; i < irr.length; i++)
//		{
//			System.out.print(irr[i]);
//		}

	}

}
