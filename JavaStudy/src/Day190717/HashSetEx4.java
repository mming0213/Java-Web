package Day190717;

import java.util.HashSet;
import java.util.Objects;

class Person2{
	String name;
	int age;
	
	Person2(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//Equals와 hashCode를 하나라도 재정의 하지 않으면 중복저장됌.
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age == tmp.age;
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(name, age); //같은 클래스안에서는 유일함.
	}
	
	public String toString() {
		return name + ":" + age;
	}
}

public class HashSetEx4 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));
		set.add(new Person2("David",10));

		System.out.println(set);
	}

}
