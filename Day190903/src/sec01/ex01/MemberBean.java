package sec01.ex01;

import java.sql.Date;

public class MemberBean {

	private String id; 
	private String name; 
	private String address; 
	private String state;
	private String zip;
	private String country;
	private String contact ;
	private String email;
	
	public MemberBean()
	{
		
	}
	
	//인자가 네개인 생성자 추가
//	public MemberBean(String id, String pwd, String name, String email) {
//		this.id = id;
//		this.pwd = pwd;
//		this.name = name;
//		this.email = email;
//	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	

}
