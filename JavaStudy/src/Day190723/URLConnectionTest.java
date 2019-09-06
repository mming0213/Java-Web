package Day190723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnectionTest {

	public static void main(String[] args) {
		String input = "query=un";
		try {
			/*
			 * set up
			 */
			URL naver = new URL("http://kin.naver.com/search/list.nhn");
			HttpURLConnection urlConn = (HttpURLConnection)naver.openConnection();
			urlConn.setDoOutput(true); //Output을 사용가능하게 설정
			
			/*
			 * write-서버에 Write
			 */
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConn.getOutputStream()));
			bw.write(input);
			bw.flush();
			bw.close();
			
			/*
			 * read - 서버에서 결과 Read
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
			String inputLine;
			while((inputLine=br.readLine()) != null) {
				System.out.println(inputLine);
			}
			br.close();
			
		}catch(Exception e) {
			System.out.println("Exception: " + e.toString());
		}

	}

}
