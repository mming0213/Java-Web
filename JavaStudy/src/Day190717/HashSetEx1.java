package Day190717;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "4", "4", "4"};
		
		//HashSet
		//Set Interface�� ������ ���� ��ǥ���� Collection
		//Collection���� �ߺ� ��ҵ��� ���� ����
		//
		Set set = new HashSet();
		
		for(int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); //HashSet�� objArr�� ��ҵ��� �����Ѵ�.
		}
		
		//HashSet�� ���ڵ� ��ҵ��� ����Ѵ�.
		System.out.println(set);
	}

}
