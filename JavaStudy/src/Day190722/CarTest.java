package Day190722;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Driver{
	private String name;
	private int licenceNo;
	private HashMap<String, Car> cars = new HashMap<String, Car>();
	private int hisMaxIndex = 3;
	private int hisIndex;
	private Accident[] history = new Accident[hisMaxIndex];

	Driver(String name, int licenceNo) {
		this.name = name;
		this.licenceNo = licenceNo;
	}
	
	//소유자동차 추가
	//carNo(차량번호), type(차종), volume(배기량)
    //carNo를 key로 HashMap에 추가한다
    //동일한 자동차를 추가할 수 없다
    //HashMap에는 Key는 String, Value에는 Car class만 추가가능하다
	public void addCar(String carNo, String type, int volume) throws Exception {
		Car c = new Car(carNo, type, volume);
		if(cars.containsKey(c.getCarNo())) {
			throw new Exception("동일한 차는 추가할 수 없습니다.");
		}
		else {
			cars.put(carNo, c);	
		}
	}
	
	//carNo/type/volume 출력
	public void printCars() {
		Set set = cars.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Entry e = (Entry)it.next();
			System.out.println(e.getValue());
			//Car c = (Car)e.getValue();
			//System.out.println(c.getCarNo() + "/" + c.getType() + "/" + c.getVolume());
			
		}

	}
	
	//사고 이력 추가
	public void addAccident(Accident ac) throws Exception {	
		//사고이력 추가 시 Array size를 넘어설 경우 Array size를 2배로 늘려서 추가한다
		if(hisIndex ==  hisMaxIndex-1) {
			Accident[] old = history; //old배열에 기존배열 데이터를 담아둔다.
			hisMaxIndex = 2 * hisMaxIndex;
			history = new Accident[hisMaxIndex];
			
			for(int i = 0; i < hisIndex; i++) {
				history[i] = old[i];
			}
		}
		
		//사고이력 추가 시 Car는 Driver가 소유하고 있는 Car만 추가가능 하다
		if(cars.containsKey(ac.getCar().getCarNo())) {
			history[this.hisIndex++] = ac;
		}else {
			history[this.hisIndex++] = ac;
			throw new Exception("소유하고 있는 자동차가 아닙니다.");
		}
	}
	
	//사고 이력 출력
	public void printAccident() {
		//System.out.println(history.length);
		for(int i = 0; i < this.hisIndex; i++)
		{
			Car info = history[i].getCar();
			System.out.println("사고이력 :" + history[i].getLocation() + "/" + history[i].getDate() + ", 차량정보 :" + info.getCarNo() + "/" + info.getType() + "/" + info.getVolume());
		}
	}
}


class Accident{
	private String location;
	private String date;
	private Car car;
	
	Accident(String location, String date, Car car) {
		this.location = location;
		this.date = date;
		this.car = car;
	}
	
	public void setLocaion(String location) {
		this.location = location;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}
	
}

class Car{
	private String carNo;
	private String type;
	private int volume;
	
	public Car(String carNo, String type, int volume) {
		this.carNo = carNo;
		this.type = type;
		this.volume = volume;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	public String getCarNo(){
		return carNo;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume(){
		return volume;
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
	
	public String toString() {
		return carNo + "/" + type + "/" + volume;
	}
	
}

public class CarTest {

	public static void main(String[] args) {
		Driver d = new Driver("홍길동", 12345678);
		Car c = new Car("1111", "티볼리", 5000);
		Car c2 = new Car("2222", "모닝", 5000);
		Car c3 = new Car("1234", "모닝", 5000);
		Accident ac = new Accident("로타리사거리","20190512", c);
		Accident ac2 = new Accident("로타리사거리2","20190512", c2);
		Accident ac3 = new Accident("강남역","20190512", c3);
				
		try {
			d.addCar("1111", "SUV", 5000);
			//d.addCar("1111", "SUV", 5000);
			d.addCar("2222", "경차", 3000);
			d.addCar("3333", "경차", 3000);
			d.printCars();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			d.addAccident(ac);
			d.addAccident(ac2);
			//d.addAccident(ac3);
			d.printAccident();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
