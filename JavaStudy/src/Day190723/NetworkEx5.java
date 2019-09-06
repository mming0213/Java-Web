package Day190723;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class NetworkEx5 {

	public static void main(String[] args) {
		URL url = null;
		InputStream in = null; //리소스에서 읽어들인다.
		FileOutputStream out = null;
		String address = "http://localhost:8090/pro07/memberForm.html";
	
		int ch = 0;
		
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("memberForm.html");
			
			while((ch = in.read()) != -1) {
				System.out.println("downloading..");
				out.write(ch);
			}
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
