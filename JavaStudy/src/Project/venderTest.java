package Project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;

class Vender{
   private String name;

   Vender(String name){
      this.name = name;
   }
   
   public void ordered() {
      System.out.println("상품 주문을 확인했습니다.");
   }
   
   public void send(Customers c) {
      System.out.println(c.getName() + " 고객님께 상품을 보냈습니다.");
   }
   
}

class Product{
   private int number;
   private String name;
   private int price;
   Vender vender;
   
   public Product(int number, String name, int price, Vender vender) {
      this.number = number;
      this.name = name;
      this.price = price;
      this.vender = vender;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public Vender getVender() {
      return vender;
   }
   public void setVender(Vender vender) {
      this.vender = vender;
   }
   //제품 정보 출력
   public void printstock(){
      System.out.println("제품번호:" + this.number + ", 제품이름:" + this.name + ", 제품가격:" + this.price + "원");
   }
   //재고확인
   public boolean checkstock() {
      return true;
   }
   
   public boolean equals(Object obj) {
		if (obj != null && obj instanceof Product) {
			String thisTmp = number + "/" + name;
			String tmp = ((Product)obj).getName() + "/" + ((Product)obj).getNumber();
			
			return thisTmp.equals(tmp);
		} 
		else return false;		
	}
	
	public int hashCode() {
		return Objects.hash(number);
	}
   
}

class Order{
   private int quantity;
   private String pay;
   Product p;
   HashMap orderinfo = new HashMap(); 
   
   Order(Product p, int quantity, String pay){
      this.p = p;
      this.quantity = quantity;
      this.pay = pay;
   }
   

   public void paying() {
      System.out.println("결제수단:" + pay + ", 총금액:" + p.getPrice()*this.quantity + "원 결제되었습니다.");
            
   }

   public void addOrder(Order order)
   {
      String strinfo = order.p.getName() + order.p.getPrice();
      orderinfo.put(order.p.getNumber(), strinfo);
   }
   
   public void printOrder() {
      Set set = orderinfo.entrySet();
      Iterator it = set.iterator();
      
      while(it.hasNext()) {
         Map.Entry e = (Map.Entry)it.next();
         Product p = (Product)e.getValue();
         System.out.println("id = " + p.getNumber() + "/" + p.getName() + "/" + p.getPrice());

 		}
      }
}

class Customers{
   private String name;
   private String address;
   private String phonenumber;
   HashMap info = new HashMap();
   Order order;
   //Join j; //아이디, 패스워드 포함
   
   Customers(String name, String address, String phonenumber){
      this.name = name;
      this.address = address;
      this.phonenumber = phonenumber;
      this.order = order;
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
   public String getPhonenumber() {
      return phonenumber;
   }
   public void setPhonenumber(String phonenumber) {
      this.phonenumber = phonenumber;
   }

   //회원가입
   public void join(String id, String pw) throws Exception {
      if(info.containsKey(id)) {
         throw new Exception("id가 중복되었습니다.");
      }
      else {
         info.put(id, pw);
      }
   }
   //회원정보 출력
   public void printCustomers(){
      System.out.println("이름:" + this.name + ", 주소:" + this.address + ", 전화번호:" + this.phonenumber );
   }
   
}

public class venderTest {

   public static void main(String[] args) throws Exception {
      Vender v = new Vender("무신사");
      Product p = new Product(100, "티셔츠", 10000, v);
      
      Order order = new Order(p, 10, "credit");
      
      Customers c = new Customers("홍길동", "서울시 강남구", "010-0000-0000");
      try {
         c.join("aaa", "www");
         //c.join("aaa", "www"); //HashMap 키 값(id) 중복 x
         c.printCustomers();
         c.order.addOrder(order);
         c.order.printOrder();
//         c.order.paying();
//         c.order.p.printstock();
//         c.order.p.vender.ordered();
//         c.order.p.vender.send(c);
      }catch(Exception e) {
         e.printStackTrace();
      }

   }

}