

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class Book implements Comparable{
	private String title;
	
	public Book(String t){
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return title;
	}
	
	public int compareTo(Object obj) {
		Book book = (Book) obj;
		return title.compareTo(book.getTitle());
	}
}

class Book3{
	private String title;
	
	public Book3(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return title;
	}
}

//Comparator에 equals 메소드도 존재하지만 재정의 하라고 안뜨는 건
//Object class에 equals 메소드가 구현되어 있기 때문
class BookCompare implements Comparator{
	public int compare(Object arg0, Object arg1) {
		return ((Book3)arg0).getTitle().compareTo(((Book3)arg1).getTitle());
	}
}


//TreeSet 원소는 반드시 Comparable이어야한다.
//TreeSet를 사용하려면 집합에 들어가는 원소가 comparable을 구현하는 유형이어야한다.
//Compparator를 인자로 받아 들이는 Treeset의 오버로드된 생성자를 사용
public class TreeSetTest {	
	public void go() {
		//Comparable 이용
		Book b1 = new Book("How Cats Work");
		Book b2 = new Book("Remix your Body");
		Book b3 = new Book("Finding Emo");
		
		TreeSet tree = new TreeSet();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		//정렬되어 조회된다.
		System.out.println("1:"+tree);
		
		//Comparator이용
		Book3 t1 = new Book3("How Cats Work");
		Book3 t2 = new Book3("Remix your Body");
		Book3 t3 = new Book3("Finding Emo");
		
		TreeSet tree2 = new TreeSet(new BookCompare());
		tree2.add(t1);
		tree2.add(t2);
		tree2.add(t3);
		
		//정렬되어 조회된다.
		System.out.println("2:"+tree2);
		//첫번째값 조회
		System.out.println("3:"+tree2.first());
		//마지막값 조회
		System.out.println("4:"+tree2.last());
		//삭제
		System.out.println("5:"+ tree2.remove(new Book3("Finding Emo")));
		System.out.println("6:" + tree2);
		tree2.add(t3);
		
		//인자보다 값이 작은 항목들의 집합
		SortedSet ss = tree2.headSet(new Book3("Rremix your Body"));
		System.out.println("7:" + ss);
		//인자보다 값이 크거나 같은 항목들이 집합
		//SortedSet ss2 = tree2.tailSet(new Book3("Finding Emo"), new Book3("Remix your Body"));
		
		
		
		
		
	} 
	
	
	public static void main(String[] args) {
		new TreeSetTest().go();

	}

}
