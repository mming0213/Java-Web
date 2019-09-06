package Day190722;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean append = false;
		int i, len = 0;
		String strFile01 = "C:/Temp/test2.java";
		String strFile02 = "C:/Temp/fileStreamTest.txt";
		
		FileReader  in = null;
		FileWriter  out = null;
		try {
			//�־��� File ��ü�� �̿��Ͽ� FileReader ��ü�� ����.
			//���Ͽ� ����� byte�� �����ڵ� ���ڷ� ��ȯ�Ͽ� �о� ���Դϴ�.
			in = new FileReader(new File(strFile01));
			//�־��� ���ϸ��� ���� FileReader ��ü�� ����.
			//����� �����ڵ� ���ڿ��� �ý��ۿ� �´� ����Ʈ ���� ���ڵ��� byte�� ��ȯ�Ͽ� ���Ͽ� �����Ѵ�.
			out = new FileWriter(strFile02, append);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		try {
			while((i = in.read()) != -1){ //1byte�� �о 
					System.out.println(i); //1byte�̹Ƿ� �ѱ��� ����
					out.write(i);
					len++;
			}
		in.close();
		out.close();
		System.out.println(len+"bytes are copied");
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
