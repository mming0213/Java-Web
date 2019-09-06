package Day190712;

public class MathTest {

	public static void main(String[] args) {
		//1.static double abs(double a) float, int, long 
		//절대값 반환
		int l = Math.abs(-10);//10
		double d = Math.abs(-10.0);//10.0
		System.out.println(l + "," + d);

		//2.static double ceil(double a)
		//주어진 값을 올림하여 반환한다. 
		double d2 = Math.ceil(10.1);//11.0
		double d3 = Math.ceil(-10.1);//-10.0
		double d4 = Math.ceil(10.000015);//11.0
		System.out.println(d2 + "," + d3 + "," + d4);
		
		//3.static double floor(double a) 
		//주어진 값을 버림하여 반환한다.
		double d5 = Math.floor(10.8); //10.0
		double d6 = Math.floor(-10.8); //-11.0
		System.out.println(d5 + "," + d6);
		
		//4.static double max(double a, double b) float, int, long 
		//주어진 두 값을 비교하여 큰 쪽을 반환
		double d7 = Math.max(9.5, 9.50001); //9.50001
		int i = Math.max(0, -1); //0
		System.out.println(d7 + "," + i);
		
		//5.static double min(double a, double b) float, int, long 
		//주어진 두 값을 비교하여 작은쪽 반환
		double d8 = Math.min(9.5, 9.50001); //9.5
		int i2 = Math.min(0, -1);//-1
		System.out.println(d8 + "," + i2);
		
		//6.static double random()
		//0.0 ~ 1.0범위의 임의의 double 반환
		double d9 = Math.random(); //0.0<=d9<1.0
		int i3 = (int)(Math.random()*10)+1; //1<=i3<11
		System.out.println(d9 + "," + i3);
		
		//7.static double rint(double a) 
		//주어진 double값과 가장 가까운 정수값을 double형으로 반환한다.
		double d10 = Math.rint(5.5);//6.0
		double d11 = Math.rint(5.1);//5.0
		double d12 = Math.rint(-5.5);//-6.0
		double d13 = Math.rint(-5.1);//-5.0
		System.out.println(d10 + "," + d11 + "," + d12 + "," + d13);
		
		//8.static long round(double a) 
		//static long round(float a) 
		//소수점 첫째자리에서 반올림한 long값을 반환
		long l2 = Math.round(5.5);//6
		long l3 = Math.round(5.11);//5
		long l4 = Math.round(-5.5);//-5
		long l5 = Math.round(-5.1);//-5
		double d14 = 90.7552;//10.0
		double d15 = Math.round(d14*100)/100.0;
		System.out.println(l2 + "," + l3 + "," + l4 + ","+ l5);
		System.out.println(d15);//90.76
	}

}
