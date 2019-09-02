package test01;

public class MemberBean {

	private String member_id; 
	private String name; 
	private String password;
	private String regdate;
	private String check;
	private String newpassword;
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	
	//인자가 네개인 생성자 추가
//	public MemberBean(String id, String pwd, String name, String email) {
//		this.id = id;
//		this.pwd = pwd;
//		this.name = name;
//		this.email = email;
//	}
	
	
	
	

}
