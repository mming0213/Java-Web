package Day190712;

class Book{
	private int number;
	private String title;
	private String author;
	Book book;
	Book(){
	}
	
	Book(int number, String title, String author){
		this.number = number;
		this.title = title;
		this.author = author;
	}
	
	public void SetMethod(Book book){
		this.book = book;
	}
	
	public String GetMethod(){
		return this.number + "," +this.title + "," + this.author;
	}
	
	public boolean equals(Object obj)
	{
		if(obj != null && obj instanceof Book)
		{
			return number==((Book)obj).number;
		}
		else
		{
			return false;
		}
	}
	
	public int getLateFee() {
		return 0;
	}
	
}

class Animation extends Book{
	public int getLateFee() {
		return 300;
	}
}

class Science extends Book{
	public int getLateFee() {
		return 200;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book b = new Book(1, "어린왕자", "생텍쥐페리");
		Book b2 = new Book(2, "개미", "베르나르베르베르");
		Book b3 = new Book(2, "죽음", "베르나르베르베르");
		
		Book an = new Animation();
		b.SetMethod(b2);
		b.GetMethod();
		System.out.println(an.getLateFee());
		
//		b.SetMethod(b2);
//		System.out.println(b2.GetMethod());
//		
//		b.SetMethod(b);
//		System.out.println(b.GetMethod());
		
		
		System.out.println(b2.equals(b3));

	}

}
