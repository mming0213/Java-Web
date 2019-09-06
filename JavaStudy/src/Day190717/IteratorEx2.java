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
		//Iterator: ����� ��Ҹ� �����ϴµ� ����ϴ� interface
		Iterator it = original.iterator();
		
		//hasNext() : �о�� ��Ұ� �����ִ��� Ȯ��
		while(it.hasNext()) {
			copy1.add(it.next());
		}
		
		System.out.println("=Original���� copy1�� ����(copy)=");
		System.out.println("original:" + original);
		System.out.println("copy1:" + copy1);
		System.out.println();
		
		it = original.iterator(); //Iterator�� ������ �ȵǹǷ�, �ٽ� ���;� �Ѵ�.
		
		while(it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		}
		System.out.println("=Original���� copy2�� ����(move)=");
		System.out.println("original:" + original);
		System.out.println("copy2:" + copy2);
		
	}

}