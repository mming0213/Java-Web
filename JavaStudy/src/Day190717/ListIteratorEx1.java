package Day190717;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorEx1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		
		//ListIterator
		//Iterator을 상속받아서 기능추가
		//Iterator은 단방향으로 이동할 수 있으나 ListIterator는 양방향으로 이동 가능.
		ListIterator it = list.listIterator();
		//hasNext() : 읽어올 다음 요소가 있는지 확인
		while(it.hasNext()) {
			System.out.print(it.next());//순방향으로 진행하면서 읽어온다.
		}
		System.out.println();
		
		//hasPrevious() : 읽어올 이전 요소가 있는지 확인
		while(it.hasPrevious()) {
			System.out.print(it.previous()); //역방향으로 진행하면서 읽어온다.
		}
		System.out.println();
	}

}
