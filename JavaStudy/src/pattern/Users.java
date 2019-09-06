package pattern;

import java.util.ArrayList;
import java.util.List;

public class Users implements Cloneable{
	private List<String> userList;
	public Users(){
		userList = new ArrayList();
	}
	
	public Users(List list)
	{
		this.userList = list;
	}
	
	public void loadData() {
		userList.add("1");
		userList.add("2");
		userList.add("3");
		userList.add("4");
	}
	
	public void print() {
		System.out.println(userList);
	}
	
	public List<String> getUserList(){
		return userList;
	}
	
	//해당 클래스에 카피본을 만드는 기능, 객체에 대한 복사본을 
	public Object clone() throws CloneNotSupportedException{
		List<String> temp = new ArrayList();
		
		for(String s:this.getUserList()) {
			temp.add(s);
		}
		return new Users(temp);//카피본을 복사해서 리턴하게끔.
	}
	
	public static void main(String[] args) throws Exception{
		Users originUsers = new Users();
		originUsers.loadData();
		Users cloneUsers = (Users)originUsers.clone();
		cloneUsers.print();

	}

}
