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
	private String seats_S[] = new String[10]; //좌석(S석, A석, B석)
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
	
	//좌석 타입에 따른 출력
	public void printSeat(String seat[])
	{
		for(int i = 0; i < seat.length; i++) 
		{
			System.out.print(seat[i] + ",");
		}	
		System.out.println();
	}
	
	//좌석에 예약자명을 추가
	public void inputSeat(String seat[])
	{
		System.out.println("이름을 입력해주세요.");
		String name = sc.next();
		while(true) {
			System.out.println("좌석 번호를 입력해주세요.");
			int num = sc.nextInt();
			num -= 1;
			if(seat[num].equals("_"))
			{
				seat[num] = name;
				break;
			}
			else 
			{
				System.out.println("다시 좌석을 선택해주시기 바랍니다.");
			}
		}
	}
	
	//예약
	public void addReserve() 
	{
		//좌석 선택
		while(true) 
		{
			System.out.println("좌석 (S석, A석, B석)을 선택해주시 기 바랍니다.");
			String str = sc.next();
			switch(str) 
			{
				case "S":
					System.out.println("S석: ");
					printSeat(seats_S);
					inputSeat(seats_S);
					return;
				case "A":
					System.out.println("A석: ");
					printSeat(seats_A);
					inputSeat(seats_A);
					return;
				case "B":
					System.out.println("B석: ");
					printSeat(seats_B);
					inputSeat(seats_B);
					return;
				default:
					System.out.println("다시 입력해 주시기 바랍니다.");
			}
		
		}
		
		
	}
		
		
	//조회
	//모든 좌석 출력
	public void allPrintSeates() 
	{
		System.out.println("S석 =>");
		printSeat(seats_S);
		System.out.println("A석 =>");
		printSeat(seats_A);
		System.out.println("B석 =>");
		printSeat(seats_B);
	
	}
	
	//취소
	//취소는 예약자의 이름을 입력받아 취소한다.
	//없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 오류메세지를 출력하고 사용자가 다시 시도하도록 한다. 
	public void cancelReservation()
	{
		while(true) 
		{
			System.out.println("좌석 (S석, A석, B석)을 선택해주시기 바랍니다.");
			String str = sc.next();
			switch(str) 
			{
				case "S":
					System.out.println("S석: ");
					printSeat(seats_S);
					delect(seats_S);
					break;
				case "A":
					System.out.println("A석: ");
					printSeat(seats_A);
					delect(seats_A);
					break;
				case "B":
					System.out.println("B석: ");
					printSeat(seats_B);
					delect(seats_B);
					break;
				default:
					System.out.println("다시 입력해 주시기 바랍니다.");
			}
		
		}
	}
	
	public void delect(String seat[]) 
	{

		System.out.println("취소할 예약자명을 입력하세요.");
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
	private String name; //예약자명
	private String seatNum; //좌석번호
	private String seatType; //좌석 타입
	private int reserveNum; //예약번호
	
	public int getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	//좌석 타입, 예약자 이름, 좌서번호를 순서대로 입력받아 예약한다. 
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
	private String concertName; //공연
	private Date concertDate; //공연일자
	
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
		System.out.println("======콘서트 예약 시스템=======");
		

		try {
			Concert concert
			= new Concert("성시경콘서트", f.parse("2019-08-01"));
			ReservationSystem system = new ReservationSystem();
		
		while(true) {
			System.out.println("예약:1, 조회:2, 취소:3, 나가기:4");
			System.out.println("메뉴를 선택하시기바랍니다.");
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
					System.out.println("다시 입력해 주시기 바랍니다.");
			}
		}
		

		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

}
