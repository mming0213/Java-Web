package Day190715;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("로또 번호 추출 개수 입력:");
		int gameCnt = sc.nextInt();
		
		for(int i = 1; i <= gameCnt; i++) {
			System.out.println(i + "번째 로또 번호:" + lotto.lottoNumbers());
		}
	}
	
	String lottoNumbers() {
		List<Integer> lottoNum = new ArrayList<Integer>();
		
		//List안에 로또 번호 추가
		for(int i = 1; i <= 45; i++) {
			lottoNum.add(i);
		}
		
		//set안의 수를 무작위로 섞는다
		Collections.shuffle(lottoNum);
		
		//set안의 수를 무작위로 섞는다.
		Collections.shuffle(lottoNum);
		
		int[] lottoNums = new int[6];
		for(int i = 0; i < 6; i++) {
			lottoNums[i] = lottoNum.get(i);
		}
		
		//정렬
		Arrays.sort(lottoNums);
		
		return Arrays.toString(lottoNums);
		
	}

}
