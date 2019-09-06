package Day190717;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "4", "4", "4"};
		
		//HashSet
		//Set Interface를 구현한 가장 대표적인 Collection
		//Collection내의 중복 요소들을 쉽게 제거
		//
		Set set = new HashSet();
		
		for(int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); //HashSet에 objArr의 요소들을 저장한다.
		}
		
		//HashSet에 저자된 요소들을 출력한다.
		System.out.println(set);
	}

}
