package Day190722;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputStream {

	public static void main(String[] args) {
		boolean append = false;
		int i, len = 0;
		String strFile01 = "C:/Temp/test2.java";
		String strFile02 = "C:/Temp/fileStreamTest.txt";
		
		InputStream in = null;
		OutputStream out = null;
		try {
			//�־��� File ��ü�� ����Ű�� ������ ����Ʈ ��Ʈ������ �б� ���� FileInputStream ��ü�� ����.
			in = new FileInputStream(new File(strFile01)); 
			//�־��� File ��ü�� ����Ű�� ������ ����Ʈ��Ʈ������ ���� ���� FileOutputStream ��ü�� ����.
			//������ ������ ������ ���� ����Ʈ�� �� ������ ����� ���ο� ������ ����(�����)
			out = new FileOutputStream(strFile02, append);
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
