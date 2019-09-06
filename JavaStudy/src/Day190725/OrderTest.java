package Day190725;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Set;

class Order implements Comparable{
	private int orderNo;
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	private Date orderDt;
	private HashMap products = new HashMap();
	
	
	Order(int orderNo, Date orderDt){
		this.orderNo = orderNo;
		this.orderDt = orderDt;
	}
	
	//주문상품 추가
	//ordProdNo : 주문항목번호
	public void addProduct(int ordProdNo, Product p) {
		products.put(ordProdNo, p);
	}
	
	//주문상품 삭제
	public void delProduct(int ordProdNo) {
		products.remove(ordProdNo);
	}
	
	//주문상품 변경
	public void chgProduct(int ordProdNo, Product p) {
		products.replace(ordProdNo, p);
	}
	
	//주문상품을 키를 기준으로 정렬하여 출력
	public void printKeyBySort() {
		Set set = products.entrySet();
		List list = new ArrayList(set);
		System.out.println("=Key 기준으로 정렬하여 출력=");
	
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	//주문상품을 Value를 기준으로 정렬하여 출력.
	public void printValuBySort() {
		List list = new ArrayList();
		list.addAll(products.values());
		Collections.sort(list, new ValueSort());

		System.out.println("=Value 기준으로 정렬하여 출력=");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Product p = (Product)it.next();
			System.out.println(p.getProductNo() + "/" + p.getProductNm());
		}	
	}
	
	@Override
	public int compareTo(Object obj) {
		Order p = (Order) obj;
		
		return this.orderNo - p.getOrderNo();
	}
	
}

class ValueSort implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		if(p1.getProductNo() > p2.getProductNo()) {
			return 1;
		}else if(p1.getProductNo() < p2.getProductNo()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}

class Product{
	private int productNo;
	private String productNm;
	
	Product(int productNo, String productNm){
		this.productNo = productNo;
		this.productNm = productNm;
	}
	
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
	public String toString() {
		return productNo + "/" + productNm;
	}
	
}


public class OrderTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		Product p1 = new Product(2234, "휴지");
		Product p2 = new Product(5678, "사과");
		Product p3 = new Product(1101, "텀블러");
		Product p4 = new Product(3333, "핸드크림");
		
		Order od = new Order(1111, f.parse("2019-07-25"));
		od.addProduct(3, p1);
		od.addProduct(1, p2);
		od.addProduct(2, p3);
		od.addProduct(4, p4);
		od.printKeyBySort();
		
		System.out.println();
		od.printValuBySort();
		int i = 9;
		System.out.println(i++);
		

	}

}
