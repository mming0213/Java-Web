

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {
			Set set = new HashSet();
			
			for(int i = 0; set.size() < 6; i++) {
				int num = (int)(Math.random()*45)+1;//1~45
				set.add(new Integer(num)); //중복되는 값을 알아서 처리함.
			}
			
			List list = new LinkedList(set); //LinkedList(Collection c)
			Collections.sort(list); //Collections.sort(List list)
			System.out.println(list);
	}

}
