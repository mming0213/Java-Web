package Day190726;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

abstract class Food{
	
	private int foodNo; //���Ĺ�ȣ
	private String foodNm; //�����̸�
	private int time; //�����ð�
	
	Food(int foodNo, String foodNm, int time){
		this.foodNo = foodNo;
		this.foodNm = foodNm;
		this.time = time;
	}
	
	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodNm() {
		return foodNm;
	}

	public void setFoodNm(String foodNm) {
		this.foodNm = foodNm;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public String toString() {
		return foodNo + "/" + foodNm + "/" + time;
	}
	
	public abstract int foodcnt();
}

class Noodle extends Food{
	static int noodle_cnt = 0;
	
	Noodle(int foodNo, String foodNm, int time) {
		super(foodNo, foodNm, time);
		
	}
	
	public int foodcnt() {
		return noodle_cnt++;
	}

}


class FriedRice extends Food{
	static int friedrice_cnt = 0;
	
	FriedRice(int foodNo, String foodNm, int time) {
		super(foodNo, foodNm, time);	
	}
	
	public int foodcnt() {
		return friedrice_cnt++;
	}
	
}

class AutoFood{
	private int shopNo;
	private Date setupDt;
	private LinkedList foods = new LinkedList();
	private ArrayList serviceFoods = new ArrayList();
	Noodle n;
	FriedRice f;
	
	AutoFood(int shopNo, Date setupDt){
		this.shopNo = shopNo;
		this.setupDt = setupDt;
	}
	
	//���� �ֹ�
	//�ֹ� �� �����ð��� �������� �����Ѵ�.(�����ð��� ª�� ������ ������)
	//�ֹ��� ��������(Ŭ����)���� �� �ֹ� ������ count�Ѵ�.
	public void orderFood(Food f) {
		foods.add(f);
		Collections.sort(foods, new FoodtimeSort());
		f.foodcnt();
	}

	public void prinOrderFood() {
		for(int i = 0; i < foods.size(); i++) {
			System.out.println(foods.get(i));
		}
	}
	
	//�ֹ����Ŀ��� �����ϰ� ������ �������� �̵���Ų��
	public void serviceFood(Food f) {
		foods.remove(f);
		serviceFoods.add(f);
	}
	
	//��������(Ŭ����)���� �� �ֹ� ������ ����Ѵ�
	public void printTotalCount() {
		System.out.println("������ �ֹ����� : " + Noodle.noodle_cnt);
		System.out.println("�������� �ֹ����� : " + FriedRice.friedrice_cnt);
	}

}

class FoodtimeSort implements Comparator<Food>{
	@Override
	public int compare(Food f1, Food f2) {
		if(f1.getTime() > f2.getTime()) {
			return 1;
		}else if(f1.getTime() < f2.getTime()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}


public class FoodTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Food f1 = new Noodle(1, "����", 20);
		Food f2 = new FriedRice(2, "������", 10);
		Food f3 = new FriedRice(3, "������", 50);
		
		AutoFood af = new AutoFood(1234, f.parse("2019-07-26"));
		af.orderFood(f1);
		af.orderFood(f2);
		af.orderFood(f3);
		af.prinOrderFood();
		af.printTotalCount();
		
	
	}

}
