package week02;

class Point implements Cloneable{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {//오버라이딩
		return "x="+ x +",y=" + y;
	}
	
	public Object clone() { //오버라이딩
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {} //clone()은 반드시 예외처리를 해주어야 한다.
		return obj;
	}
}

public class CloneEx1 {

	public static void main(String[] args) {
		
		Point original = new Point(3,5);
		Point copy = (Point)original.clone();
		System.out.println(original);
		System.out.println(copy);

	}

}
