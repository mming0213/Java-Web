package week01;

public class ClassTest extends Object{
	private int[] sub;
	private float avg;
	
	public ClassTest() {
		sub = new int[4];
		avg = 0.0f;
	}
	
	public void calc(){
		int tot = 0;
		for(int a = 0; a < sub.length; a++)
		{
			tot += sub[a];
		}
		avg = tot/sub.length;
	}
	
	public static class ClassTest_Inner{ //Nested class(중첩클래스)
		private String[] subname = {"국어", "영어", "수학"};
		
		public String getSubname(int x){
			return subname[x];

		}
	}
	
	public static void main(String[] args) {
		ClassTest ct = new ClassTest();
		
		
	}
	
}
	
