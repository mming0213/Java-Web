package week01;

public class homewort {

	public static void main(String[] args) {
		//실습1: 최대값/최소값 구하기
//		int[] score = {79, 88, 91, 33, 100, 55, 95};
//		int max = score[0];
//		int min = score[0];
//		
//		for(int i = 0; i < score.length; i++)
//		{
//			if(max < score[i]) max = score[i];
//			if(min > score[i]) min = score[i];
//		}
//		
//		System.out.println("최대값: " + max);
//		System.out.println("최솟값: " + min);

		//실습2: 내림차순 정렬하기 100, 95, 91, 88, 79, 33 
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		for(int i = 0; i < score.length-1; i++)
		{
			for(int j = 0; j < score.length-i-1; j++)// 0~5 0~4
			{
				if(score[j] < score[j+1])
				{
					int temp = score[j+1];
					score[j+1] = score[j];
					score[j] = temp;
				}
				
//				for(int k = 0; k < score.length; k++)
//				{
//					System.out.print(score[k] + " ");
//				}
//				System.out.println();
				
			}
		}
		
		for(int k = 0; k < score.length; k++)
		{
			System.out.print(score[k] + " ");
		}
		System.out.println();
	}

}
