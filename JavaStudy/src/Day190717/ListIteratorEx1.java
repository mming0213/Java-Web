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
		//Iterator�� ��ӹ޾Ƽ� ����߰�
		//Iterator�� �ܹ������� �̵��� �� ������ ListIterator�� ��������� �̵� ����.
		ListIterator it = list.listIterator();
		//hasNext() : �о�� ���� ��Ұ� �ִ��� Ȯ��
		while(it.hasNext()) {
			System.out.print(it.next());//���������� �����ϸ鼭 �о�´�.
		}
		System.out.println();
		
		//hasPrevious() : �о�� ���� ��Ұ� �ִ��� Ȯ��
		while(it.hasPrevious()) {
			System.out.print(it.previous()); //���������� �����ϸ鼭 �о�´�.
		}
		System.out.println();
	}

}
