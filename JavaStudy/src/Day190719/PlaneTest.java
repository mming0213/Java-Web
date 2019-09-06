package Day190719;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Plane{	
	private String model;
	private String airline;
	private HashSet fixHis = new HashSet(); //���� �̷�
	
	Plane(String model, String airline){
		this.model = model;
		this.airline = airline;
	}
	
	//���� �̷� �߰�.
	//���� �����̷��� �߰��� �� ����(airport/date/cmt)
	public void addFixHis(FixHis his) {		
		fixHis.add(his);
	}
	
	//�����̷� ���
	//�����̷��� ���: ����-����-�����
	public void printFixHis() {
			Iterator it = fixHis.iterator();
			
			while(it.hasNext()) {
				FixHis fh = (FixHis)it.next();
				System.out.println(fh.getAirport() + "-" + fh.getDate() + "-" + fh.getCmt() );
			}
	}

}

//�����̷� Ŭ����
class FixHis{
	private String airport;
	private String date;
	private String cmt; //��������

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
		Plane p = new Plane("A-34", "�ƽþƳ��װ�");
		FixHis f = new FixHis("��õ����", "20190719", "��������");
		FixHis f1 = new FixHis("��õ����", "20190719", "��������");
		FixHis f2 = new FixHis("��������", "20190719", "��������");
		
		p.addFixHis(f);
		p.addFixHis(f1);
		p.addFixHis(f2);
		p.printFixHis();


	}

}
