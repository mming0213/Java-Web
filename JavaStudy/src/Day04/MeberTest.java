package Day04;

class Member{
	public String name;
	
	Member(String name){
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

class SpecialMember extends Member{
	public SpecialMember(String name) {
		super(name);
	}
	//	SpecialMember(String name){
//		super.name = name;
//	}
	
}

public class MeberTest {

	public static void main(String[] args) {
		//�ǽ�2:����Ŭ���� ����
		
		SpecialMember m = new SpecialMember("ȫ�浿");
		Member s = m;
		System.out.println(s.getName());
	}

}
