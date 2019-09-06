package Day190723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx4 {

	public static void main(String[] args) {
		//Stream���� �ٷ� �����Ͽ� Data�� �ְ� �޴´�
		URL url = null;
		BufferedReader input = null; //���ҽ����� �о���δ�.
		String address = "http://192.168.0.16:8090/pro07/memberForm.html";
		String line = "";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
