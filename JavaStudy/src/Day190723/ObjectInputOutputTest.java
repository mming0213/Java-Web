package Day190723;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectInputOutputTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//°´Ã¼Á÷·Ä
		FileOutputStream ostream = new FileOutputStream("AaTxTTest.txt");
		ObjectOutputStream p = new ObjectOutputStream(ostream);
		p.writeInt(12345);
		p.writeObject("Today");
		p.writeObject(new Date());
		p.flush();
		ostream.close();
		
		FileInputStream istream = new FileInputStream("AaTxTTest.txt");
		ObjectInputStream p2 = new ObjectInputStream(istream);
		int i = p2.readInt();
		String today = (String)p2.readObject();
		Date date = (Date)p2.readObject();
		
		System.out.println();
		System.out.println(today);
		System.out.println(date);
		istream.close();
		
		
		

	}

}
