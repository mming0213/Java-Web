package Day190722;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterTest {

	public static void main(String[] args) throws IOException {
		//StringReader, StringWriter
		//���ڿ��� �Է� Stream���� ���ڿ� ���۸� ��� Stream���� ���� ����ϴ� ���� ����� Stream
		
		int ch;
		//�Է� ���۷� ����� ���ڿ�
		String s = "Hello,Java!";
		//String s�� �Է� Stream���� �ϴ� StringReader ��ü ����
		StringReader in = new StringReader(s);
		//�־��� ũ���� ���ڿ� Buffer�� �����ϰ� �ִ�. 
		StringWriter out = new StringWriter(s.length()/2);
		//�־��� ������ŭ �ǳʶڴ�. index�� J�� �̵�
		in.skip(6);
		while((ch = in.read()) != -1) {
			out.write(ch);
			//����Կ� ���� ��¹����� size�� �þ��.
			System.out.println("read:[" + (char)ch + "]" + ",write:[" + out.toString() + "]" + out.getBuffer().length());
		}

		System.out.println("out:" + out.toString()); //Java!
		System.out.println();
		
		//StringWriter�� ������¹����� ������ ������Ŵ, !avaJ
		out.getBuffer().reverse();
		System.out.println("out:" + out.toString()); //Java!

		//System.out.println(" out:" + out.toString());
		in = new StringReader(out.toString());
		
		//Char �迭 ��� Stream ����
		CharArrayWriter out2 = new CharArrayWriter();
		while((ch = in.read()) != -1) {
			out2.write(ch);
			System.out.println("read:[" + (char)ch + "]" + ",write:[" + out2.toString() + "]" + out.getBuffer().length());
		}
		
	}

}
