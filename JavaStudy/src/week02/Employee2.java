package week02;

interface EmployeeType{
	public int getAmount();
}

class Engineer implements EmployeeType{
	public int getAmount() {
		return 100;
	}
}

class Manager2 implements EmployeeType{
	public int getAmount() {
		return 200;
	}
}

class Salesman implements EmployeeType{
	public int getAmount() {
		return 200;
	}
}

public class Employee2 {

	private EmployeeType type;
	
	public Employee2(EmployeeType type)
	{
		setType(type);
	}
	
	public void setType(EmployeeType type)
	{
		this.type = type;
	}
	
	public int getAmount()
	{
		//return type.getAmount();
		return type.getAmount();
	}
	
	public static void main(String[] args) {
		//EmployeeType e = new Engineer(); //이것도 가능!
		//System.out.println(e.getAmount());
		Engineer e = new Engineer();
		EmployeeType p = e;
		Employee2 m = new Employee2(e);
		System.out.println(m.getAmount());
//		
//		EmployeeType e2 = new Salesman();
//		System.out.println(e2.getAmount());
		
		

	}

}
