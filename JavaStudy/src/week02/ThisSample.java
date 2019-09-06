package week02;

public class ThisSample {
	private int x;
	private static int y;
	
	public void aaa(ThisSample this) {
	//public void aaa() {
		this.x = 10;
		this.y = 20;
		//ThisSample.y = 20;
	}
	
	public void bbb(ThisSample this, int x, int y){
	//public void bbb(int x, int y) {
		this.x = x;
		ThisSample.y = y;
	}
	
	public static void ccc() {
		//this.x //static에는 this가 없다.
		ThisSample.y = 10;
	}
	
//	public static void main(String[] args) {
//		
//
//	}

}
