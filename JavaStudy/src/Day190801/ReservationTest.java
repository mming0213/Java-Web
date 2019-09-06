package Day190801;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class ReservationSystem{
	private String seats_S[] = new String[10]; //�¼�(S��, A��, B��)
	private String seats_A[] = new String[10];
	private String seats_B[] = new String[10];
	Scanner sc = new Scanner(System.in);
	
	ReservationSystem(){
		for(int i = 0; i < seats_S.length; i++) 
		{
			seats_S[i] = "_";
			seats_A[i] = "_";
			seats_B[i] = "_";
			
		}
	}
	
	//�¼� Ÿ�Կ� ���� ���
	public void printSeat(String seat[])
	{
		for(int i = 0; i < seat.length; i++) 
		{
			System.out.print(seat[i] + ",");
		}	
		System.out.println();
	}
	
	//�¼��� �����ڸ��� �߰�
	public void inputSeat(String seat[])
	{
		System.out.println("�̸��� �Է����ּ���.");
		String name = sc.next();
		while(true) {
			System.out.println("�¼� ��ȣ�� �Է����ּ���.");
			int num = sc.nextInt();
			num -= 1;
			if(seat[num].equals("_"))
			{
				seat[num] = name;
				break;
			}
			else 
			{
				System.out.println("�ٽ� �¼��� �������ֽñ� �ٶ��ϴ�.");
			}
		}
	}
	
	//����
	public void addReserve() 
	{
		//�¼� ����
		while(true) 
		{
			System.out.println("�¼� (S��, A��, B��)�� �������ֽ� �� �ٶ��ϴ�.");
			String str = sc.next();
			switch(str) 
			{
				case "S":
					System.out.println("S��: ");
					printSeat(seats_S);
					inputSeat(seats_S);
					return;
				case "A":
					System.out.println("A��: ");
					printSeat(seats_A);
					inputSeat(seats_A);
					return;
				case "B":
					System.out.println("B��: ");
					printSeat(seats_B);
					inputSeat(seats_B);
					return;
				default:
					System.out.println("�ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
			}
		
		}
		
		
	}
		
		
	//��ȸ
	//��� �¼� ���
	public void allPrintSeates() 
	{
		System.out.println("S�� =>");
		printSeat(seats_S);
		System.out.println("A�� =>");
		printSeat(seats_A);
		System.out.println("B�� =>");
		printSeat(seats_B);
	
	}
	
	//���
	//��Ҵ� �������� �̸��� �Է¹޾� ����Ѵ�.
	//���� �̸�, ���� ��ȣ, ���� �޴�, �߸��� ��� � �����޼����� ����ϰ� ����ڰ� �ٽ� �õ��ϵ��� �Ѵ�. 
	public void cancelReservation()
	{
		while(true) 
		{
			System.out.println("�¼� (S��, A��, B��)�� �������ֽñ� �ٶ��ϴ�.");
			String str = sc.next();
			switch(str) 
			{
				case "S":
					System.out.println("S��: ");
					printSeat(seats_S);
					delect(seats_S);
					break;
				case "A":
					System.out.println("A��: ");
					printSeat(seats_A);
					delect(seats_A);
					break;
				case "B":
					System.out.println("B��: ");
					printSeat(seats_B);
					delect(seats_B);
					break;
				default:
					System.out.println("�ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
			}
		
		}
	}
	
	public void delect(String seat[]) 
	{

		System.out.println("����� �����ڸ��� �Է��ϼ���.");
		String name = sc.next();
		for(int i = 0;i < seat.length; i++)
		{
			if(name.equals(seat[i]))
			{
				seat[i] = "_";
				break;
			}
		}
	}
	
	
}

class ReservedPeople{
	private String name; //�����ڸ�
	private String seatNum; //�¼���ȣ
	private String seatType; //�¼� Ÿ��
	private int reserveNum; //�����ȣ
	
	public int getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	//�¼� Ÿ��, ������ �̸�, �¼���ȣ�� ������� �Է¹޾� �����Ѵ�. 
	ReservedPeople(String seatType, String name, String seatNum){
		this.name = name;
		this.seatNum = seatNum;
		this.seatType = seatType;
		this.reserveNum = reserveNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof ReservedPeople) {
			String tmp = ((ReservedPeople)obj).getName();
			return name.equals(tmp);
		} 
		else return false;		
	}
	
	public int hashCode() {
		return Objects.hash(name);
	}
	
	public String toString() {
		return name + "/" + seatNum + "/" + seatType + "/" + reserveNum + "/";
	}	
}

class Concert{
	private String concertName; //����
	private Date concertDate; //��������
	
	Concert(String concertName, Date concertDate){
		this.concertName = concertName;
		this.concertDate = concertDate;
	}
	
	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public Date getConcertDate() {
		return concertDate;
	}

	public void setConcertDate(Date concertDate) {
		this.concertDate = concertDate;
	}

}


public class ReservationTest {

	public static void main(String[] args) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("======�ܼ�Ʈ ���� �ý���=======");
		

		try {
			Concert concert
			= new Concert("���ð��ܼ�Ʈ", f.parse("2019-08-01"));
			ReservationSystem system = new ReservationSystem();
		
		while(true) {
			System.out.println("����:1, ��ȸ:2, ���:3, ������:4");
			System.out.println("�޴��� �����Ͻñ�ٶ��ϴ�.");
			int select = sc.nextInt();
			switch(select) {
				case 1:
					system.addReserve();
					break;
				case 2:
					system.allPrintSeates();
					break;
				case 3:
					system.cancelReservation();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("�ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
			}
		}
		

		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

}
