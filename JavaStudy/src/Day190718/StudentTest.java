package Day190718;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student implements Comparable{
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int compareTo(Object obj) {
		if(this.score < ((Student)obj).getScore()) {
			return -1;
		}else if(this.score > ((Student)obj).getScore()) {
			return 1;
		}
		return 0;
	}

	
}

public class StudentTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(new Student("a",5));
		list.add(new Student("b",10));
		list.add(new Student("c",1));
		list.add(new Student("d",52));
		list.add(new Student("e",23));
		
		Collections.sort(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(((Student)it.next()).getScore());
		}
	}

}
