package Day190724;


import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

class ParkingLotAdm{
	private Date startDt;
	private Date endDt;
	private final int maxCarsu; 
	private HashMap cars = new HashMap();
	private HashMap outCars = new HashMap();
	private Queue waitCars = new LinkedList(); //Queue�� ����

	
	ParkingLotAdm(Date startDt, Date endDt, int maxCarsu){
		this.startDt = startDt;
		this.endDt = endDt;
		this.maxCarsu = maxCarsu;
	}
	
	//�����ϴ� �� �߰�
	public void addCar(Car car) throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String temp = "�������:" + car.getFee() + ", �����ð�:" + f.format(car.getIntDt()) + ", �����ð�:" + f.format(car.getOutDt()) + ", �����۽ð�:" + f.format(car.getWaitStrDt());

		//�ִ� ���� �ε������� �����ε����� ���ų� ũ�� waitCars�� �������� ���� �־��ش�.
		
			if(cars.containsKey(car.getCarNo())) {
				throw new Exception("������ ���� �߰��� �� �����ϴ�.");
			}
			else {
				if(cars.size() >=  maxCarsu) {
					waitCars.add(car);
				}else {
					cars.put(car.getCarNo(), temp);
				}
			}
	}
	
	//������ ���� �����ϸ� outCars�� �߰��ϰ� ��������� �����Ѵ�.
	//��������� 30�д� 500��
	//����������� ���� ������ ������Ų��(����������� ���� �������� ���� ����)
	public int outCar(Car car) {
		int totalfee = 0;

		String temp = car.getFee() + "/" + car.getIntDt() + "/" + car.getOutDt() + car.getWaitStrDt();
		//������ ���� cars���� ����
		cars.remove(car.getCarNo());
		outCars.put(car.getCarNo(), temp);
		
		//������� ���
		long diff = car.getOutDt().getTime() - car.getIntDt().getTime();
		long diffTime = diff/(1000*60);   //���� ���� �� ����.
		totalfee = ((int)diffTime/30) * 500;
	
		//����������� ���� �ִٸ� cars�� �߰�
		if(!waitCars.isEmpty()) {
		//	cars.put(waitCars.poll(), temp);
			for(int i = 0; i < waitCars.size(); i++) {
				System.out.println(((Car)waitCars.element()).getCarNo());
			}
		}
		return totalfee;
	}
	
	public void printcars() {
		Set set = cars.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Entry e = (Entry) it.next();
			System.out.println(e.getValue());
		}
	}
	
	//�Ķ���ͷ� ������ ���ı��ؿ� ���� ���������� Sort
	public void carSort(Comparator c) {
		//if(c instanceof ) {
			
		//}else {
			
		//}
	}

	
}

class Descending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Car c1 = (Car)o1;
			Car c2 = (Car)o2;
		
			return c2.getCarNo().compareTo(c1.getCarNo());
		}
		return -1;
	} 
	
}

class Car{
	private String carNo;
	private Date intDt; //�����ð�
	private Date outDt; //�����ð�
	private int fee;
	private Date waitStrDt; //�����۽ð�
	
	Car(String carNo, Date intDt, Date outDt, int fee, Date waitStrDt){
		this.carNo = carNo;
		this.intDt = intDt;
		this.outDt = outDt;
		this.fee = fee;
		this.waitStrDt = waitStrDt;
	}
	
	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Date getIntDt() {
		return intDt;
	}

	public void setIntDt(Date intDt) {
		this.intDt = intDt;
	}

	public Date getOutDt() {
		return outDt;
	}

	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Date getWaitStrDt() {
		return waitStrDt;
	}

	public void setWaitStrDt(Date waitStrDt) {
		this.waitStrDt = waitStrDt;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Car) {
			String tmp = ((Car)obj).getCarNo();
			return carNo.equals(tmp);
		} 
		else return false;		
	}
	
	public int hashCode() {
		return Objects.hash(carNo);
	}
	
}


public class ParkingLotTest {

	public static void main(String[] args) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Date time = new Date();

		try {
			Car c = new Car("1111", f.parse("2019-07-24 07:00:00"), f.parse("2019-07-24 11:00:00"), 0, f.parse("2019-07-24 07:00:00"));
			Car c2 = new Car("2222", f.parse("2019-07-24 08:00:00"), f.parse("2019-07-24 10:00:00"), 0, f.parse("2019-07-24 07:00:00"));
			Car c3 = new Car("3333", f.parse("2019-07-24 09:00:00"), f.parse("2019-07-24 13:00:00"), 0, f.parse("2019-07-24 07:00:00"));
			Car c4 = new Car("4444", f.parse("2019-07-24 09:00:00"), f.parse("2019-07-24 13:00:00"), 0, f.parse("2019-07-24 07:00:00"));
			
			ParkingLotAdm pl = new ParkingLotAdm(f.parse("2019-07-24 09:00:00"), f.parse("2019-07-24 24:00:00"), 3);
			pl.addCar(c);
			pl.addCar(c2);
			pl.addCar(c2); //�ߺ� ó��
			pl.addCar(c3);
			pl.addCar(c4);
			pl.printcars();
//			System.out.println(pl.outCar(c));
			//pl.printcars();
			//System.out.println(pl.outCar(c2));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
