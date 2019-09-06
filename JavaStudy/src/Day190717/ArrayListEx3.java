package Day190717;

import java.util.ArrayList;
import java.util.Collections;


//Comparable: ���� ���� �� �⺻ ���ı����� �Ǵ� �޼��带 ���� 
class Book2 implements Comparable{
	private String title;
	public Book2(String t) {
		title = t;
	}
	public String getTitle() {
		return title;
	}
	public String toString() {
		return title;
	}
	@Override
	public int compareTo(Object obj) {
		Book2 book = (Book2) obj;
		return title.compareTo(book.getTitle());
	}
}

public class ArrayListEx3 {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		
		Book2 b1 = new Book2("CC");
		Book2 b2 = new Book2("AA");
		Book2 b3 = new Book2("BB");
		
		a.add(b1);
		a.add(b2);
		a.add(b3);
		
		Collections.sort(a); //List Collection ����
		
		System.out.println(a);
	}

}
