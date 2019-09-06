package week02;

public class OperatorEx3 {

	public static void main(String[] args) {
		int x = 15;
		System.out.println(10 > x && x++ < 20); //false
		System.out.println("x="+x); //15
		System.out.println(10 < x || x++ < 20); //true
		System.out.println("x="+x); //15
		
		System.out.println(10 > x & x++ < 20); //false
		System.out.println("x="+x);
		System.out.println(10 < x | x++ < 20); //ture
		System.out.println("x="+x);
		
		int y = -20, z = 40;
		int absX, absY, absZ;
		char signX, signY, signZ;
		
		absX = x>=0 ? x : -x;
		absY = y>=0 ? y : -y;
		absZ = z>=0 ? z : -z;
		System.out.println(absX);
		System.out.println(absY);
		System.out.println(absZ);
	}

}
