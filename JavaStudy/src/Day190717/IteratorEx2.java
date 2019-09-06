package Day190717;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {

	public static void main(String[] args) {
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);

		for(int i = 0; i < 10; i++)
		{
			original.add(i+" ");
		}
		//Iterator: 저장된 요소를 접근하는데 사용하는 interface
		Iterator it = original.iterator();
		
		//hasNext() : 읽어올 요소가 남아있는지 확인
		while(it.hasNext()) {
			copy1.add(it.next());
		}
		
		System.out.println("=Original에서 copy1로 복사(copy)=");
		System.out.println("original:" + original);
		System.out.println("copy1:" + copy1);
		System.out.println();
		
		it = original.iterator(); //Iterator는 재사용이 안되므로, 다시 얻어와야 한다.
		
		while(it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		}
		System.out.println("=Original에서 copy2로 복사(move)=");
		System.out.println("original:" + original);
		System.out.println("copy2:" + copy2);
		
	}

}
