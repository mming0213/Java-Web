package Day190723;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Customer<T extends Order> implements Comparable<Customer>{
	private String name;
	private int age;
	protected int point;
	private ArrayList orders = new ArrayList();

	Customer(String name, int age, int point){
		this.name = name;
		this.age = age;
		this.point = point;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public ArrayList getOrders() {
		return orders;
	}

	public void setOrders(ArrayList orders) {
		this.orders = orders;
	}
	
	public void addOrders(Order o) {
		orders.add(o);
		
	}

	@Override
	public int compareTo(Customer o) {
		System.out.println("비교 - Customer, this:" + this.name + ", object: " + o.getName());
		int thisTotPoint = this.point;
		int paramTotPoint = 0;
		
		if(o instanceof SpecialCustomer) {
			paramTotPoint = o.getPoint() + ((SpecialCustomer)o).getBonus();
		}else {
			paramTotPoint = o.getPoint();
		}
		
		if(thisTotPoint < paramTotPoint) {
			System.out.println("Customer:thisTotPoint < paramTotPoint");
			return -1;
		}else if(thisTotPoint > paramTotPoint) {
			System.out.println("Customer:thisTotPoint > paramTotPoint");
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		return name + "/" + age + "/" + point;
	}
	
}

class SpecialCustomer<T extends SpecialOrder> extends Customer<T>{
	private int bonus;

	SpecialCustomer(String name, int age, int point, int bonus){
		super(name, age, point);
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
//	public int compareTo(Customer o) {
//		System.out.println("비교 - SpecialCustomer, this" + super.getName() + ", object :" + o.getName());
//		int thisTotPoint = super.getPoint() + bonus;
//		int paramTotPoint = 0;
//		
//		if(o instanceof SpecialCustomer) {
//			paramTotPoint = o.getPoint() + ((SpecialCustomer)o).getBonus();
//		}else {
//			paramTotPoint = o.getPoint();
//		}
//		
//		if(thisTotPoint < paramTotPoint) {
//			System.out.println("SpecialCustomer:thisTotPoint < paramTotPoint");
//			return -1;
//		}else if(thisTotPoint > paramTotPoint) {
//			System.out.println("SpecialCustomer:thisTotPoint > paramTotPoint");
//			return 1;
//		}
//		return 0;
//	}
	
	public String toString() {
		return super.getName() + "/" + super.getAge() + "/" + super.getPoint() + "/" + bonus;
	}
}

class BonusSorting implements Comparator{
	@Override
	public int compare(Object arg0, Object arg1) {
		//SpecialCustomer 
		return 0;
	}
}


class Order{
	private int orderNo;
	private String product;
	private String orderDt;
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(String orderDt) {
		this.orderDt = orderDt;
	}

	Order(int orderNo, String product, String orderDt){
		this.orderNo = orderNo;
		this.product = product;
		this.orderDt = orderDt;
	}
}

class SpecialOrder extends Order{
	private String gift;
	
	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	SpecialOrder(int orderNo, String product, String orderDt,String gift){
		super(orderNo, gift, gift);
		this.gift = gift;
	}
}


public class CustomerTest {

	public static void main(String[] args) {
		//Order 자식만 사용가능
		Customer<Order> c1 = new Customer<>("홍길동", 30 , 100);
		Order o = new Order(1234, "정보보호론", "2019-07-01");
		c1.addOrders(o);
		
		//SpecialOrder만 선택가능
		SpecialCustomer<SpecialOrder> c2 = new SpecialCustomer<>("김길동", 31, 40, 20);
		SpecialOrder so = new SpecialOrder(1234, "정보보호론", "2019-07-01", "각티슈");
		c2.addOrders(so);
		
		Customer<Order> c3 = new Customer<>("염민주", 25 , 50);
		Order o3 = new Order(1234, "정보보호론", "2019-07-01");
		c3.addOrders(o3);
		
		ArrayList al = new ArrayList();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		
		//Point로 Customer 정렬, SpecialCustomer는 bonus를 더해준다.
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
	}

}
