package Day190719;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Plane{	
	private String model;
	private String airline;
	private HashSet fixHis = new HashSet(); //수리 이력
	
	Plane(String model, String airline){
		this.model = model;
		this.airline = airline;
	}
	
	//수리 이력 추가.
	//같은 수리이력을 추가할 수 없다(airport/date/cmt)
	public void addFixHis(FixHis his) {		
		fixHis.add(his);
	}
	
	//수리이력 출력
	//수리이력을 출력: 공항-날자-사고내용
	public void printFixHis() {
			Iterator it = fixHis.iterator();
			
			while(it.hasNext()) {
				FixHis fh = (FixHis)it.next();
				System.out.println(fh.getAirport() + "-" + fh.getDate() + "-" + fh.getCmt() );
			}
	}

}

//수리이력 클래스
class FixHis{
	private String airport;
	private String date;
	private String cmt; //수리내용

	FixHis(String airport, String date, String cmt){
		this.airport = airport;
		this.date = date;
		this.cmt = cmt;
	}
	
	public void setAirport(String airport) {
		this.airport = airport;
	}
	
	public String getAirport() {
		return airport;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setCmt(String cmt){
		this.cmt = cmt;
	}
	
	public String getCmt() {
		return cmt;
	}
	
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof FixHis) {
			String thisTmp = airport + date + cmt;
			String tmp = ((FixHis)obj).getAirport() + ((FixHis)obj).getDate() + ((FixHis)obj).getCmt();
			return thisTmp.equals(tmp);
		}
		else return false;
	}
	
	public int hashCode() {
		return Objects.hash(airport, date, cmt);
	}
}

public class PlaneTest {

	public static void main(String[] args) {
		Plane p = new Plane("A-34", "아시아나항공");
		FixHis f = new FixHis("인천공항", "20190719", "날개수리");
		FixHis f1 = new FixHis("인천공항", "20190719", "날개수리");
		FixHis f2 = new FixHis("김포공항", "20190719", "바퀴수리");
		
		p.addFixHis(f);
		p.addFixHis(f1);
		p.addFixHis(f2);
		p.printFixHis();


	}

}
