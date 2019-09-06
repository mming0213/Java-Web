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
	
	//�����ڵ��� �߰�
	//carNo(������ȣ), type(����), volume(��ⷮ)
    //carNo�� key�� HashMap�� �߰��Ѵ�
    //������ �ڵ����� �߰��� �� ����
    //HashMap���� Key�� String, Value���� Car class�� �߰������ϴ�
	public void addCar(String carNo, String type, int volume) throws Exception {
		Car c = new Car(carNo, type, volume);
		if(cars.containsKey(c.getCarNo())) {
			throw new Exception("������ ���� �߰��� �� �����ϴ�.");
		}
		else {
			cars.put(carNo, c);	
		}
	}
	
	//carNo/type/volume ���
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
	
	//��� �̷� �߰�
	public void addAccident(Accident ac) throws Exception {	
		//����̷� �߰� �� Array size�� �Ѿ ��� Array size�� 2��� �÷��� �߰��Ѵ�
		if(hisIndex ==  hisMaxIndex-1) {
			Accident[] old = history; //old�迭�� �����迭 �����͸� ��Ƶд�.
			hisMaxIndex = 2 * hisMaxIndex;
			history = new Accident[hisMaxIndex];
			
			for(int i = 0; i < hisIndex; i++) {
				history[i] = old[i];
			}
		}
		
		//����̷� �߰� �� Car�� Driver�� �����ϰ� �ִ� Car�� �߰����� �ϴ�
		if(cars.containsKey(ac.getCar().getCarNo())) {
			history[this.hisIndex++] = ac;
		}else {
			history[this.hisIndex++] = ac;
			throw new Exception("�����ϰ� �ִ� �ڵ����� �ƴմϴ�.");
		}
	}
	
	//��� �̷� ���
	public void printAccident() {
		//System.out.println(history.length);
		for(int i = 0; i < this.hisIndex; i++)
		{
			Car info = history[i].getCar();
			System.out.println("����̷� :" + history[i].getLocation() + "/" + history[i].getDate() + ", �������� :" + info.getCarNo() + "/" + info.getType() + "/" + info.getVolume());
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
		Driver d = new Driver("ȫ�浿", 12345678);
		Car c = new Car("1111", "Ƽ����", 5000);
		Car c2 = new Car("2222", "���", 5000);
		Car c3 = new Car("1234", "���", 5000);
		Accident ac = new Accident("��Ÿ����Ÿ�","20190512", c);
		Accident ac2 = new Accident("��Ÿ����Ÿ�2","20190512", c2);
		Accident ac3 = new Accident("������","20190512", c3);
				
		try {
			d.addCar("1111", "SUV", 5000);
			//d.addCar("1111", "SUV", 5000);
			d.addCar("2222", "����", 3000);
			d.addCar("3333", "����", 3000);
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
