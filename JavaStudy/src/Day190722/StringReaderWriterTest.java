package Day190722;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterTest {

	public static void main(String[] args) throws IOException {
		//StringReader, StringWriter
		//문자열을 입력 Stream으로 문자열 버퍼를 출력 Stream으로 각각 사용하는 문자 입출력 Stream
		
		int ch;
		//입력 버퍼로 사용할 문자열
		String s = "Hello,Java!";
		//String s를 입력 Stream으로 하는 StringReader 객체 생성
		StringReader in = new StringReader(s);
		//주어진 크기의 문자열 Buffer를 포함하고 있다. 
		StringWriter out = new StringWriter(s.length()/2);
		//주어진 개수만큼 건너뛴다. index를 J로 이동
		in.skip(6);
		while((ch = in.read()) != -1) {
			out.write(ch);
			//출력함에 따라 출력버퍼의 size는 늘어난다.
			System.out.println("read:[" + (char)ch + "]" + ",write:[" + out.toString() + "]" + out.getBuffer().length());
		}

		System.out.println("out:" + out.toString()); //Java!
		System.out.println();
		
		//StringWriter의 내부출력버퍼의 내용을 반전시킴, !avaJ
		out.getBuffer().reverse();
		System.out.println("out:" + out.toString()); //Java!

		//System.out.println(" out:" + out.toString());
		in = new StringReader(out.toString());
		
		//Char 배열 출력 Stream 생성
		CharArrayWriter out2 = new CharArrayWriter();
		while((ch = in.read()) != -1) {
			out2.write(ch);
			System.out.println("read:[" + (char)ch + "]" + ",write:[" + out2.toString() + "]" + out.getBuffer().length());
		}
		
	}

}
