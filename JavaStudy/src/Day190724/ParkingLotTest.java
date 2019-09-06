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
	private Queue waitCars = new LinkedList(); //Queue로 구현

	
	ParkingLotAdm(Date startDt, Date endDt, int maxCarsu){
		this.startDt = startDt;
		this.endDt = endDt;
		this.maxCarsu = maxCarsu;
	}
	
	//주차하는 차 추가
	public void addCar(Car car) throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String temp = "주차비용:" + car.getFee() + ", 입차시간:" + f.format(car.getIntDt()) + ", 출차시간:" + f.format(car.getOutDt()) + ", 대기시작시간:" + f.format(car.getWaitStrDt());

		//최대 주차 인덱스보다 현재인덱스가 같거나 크면 waitCars에 대기순서에 따라 넣어준다.
		
			if(cars.containsKey(car.getCarNo())) {
				throw new Exception("동일한 차는 추가할 수 없습니다.");
			}
			else {
				if(cars.size() >=  maxCarsu) {
					waitCars.add(car);
				}else {
					cars.put(car.getCarNo(), temp);
				}
			}
	}
	
	//나가는 차를 제거하면 outCars에 추가하고 주차비용을 리턴한다.
	//주차비용은 30분당 500원
	//주차대기중인 차가 있으면 주차시킨다(주차대기중인 차는 대기순서에 따라 주차)
	public int outCar(Car car) {
		int totalfee = 0;

		String temp = car.getFee() + "/" + car.getIntDt() + "/" + car.getOutDt() + car.getWaitStrDt();
		//나가는 차를 cars에서 제거
		cars.remove(car.getCarNo());
		outCars.put(car.getCarNo(), temp);
		
		//주차비용 계산
		long diff = car.getOutDt().getTime() - car.getIntDt().getTime();
		long diffTime = diff/(1000*60);   //분을 구할 수 있음.
		totalfee = ((int)diffTime/30) * 500;
	
		//주차대기중인 차가 있다면 cars에 추가
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
	
	//파라미터로 전달한 정렬기준에 따라 주차차량을 Sort
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
	private Date intDt; //입차시간
	private Date outDt; //출차시간
	private int fee;
	private Date waitStrDt; //대기시작시간
	
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
			pl.addCar(c2); //중복 처리
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
