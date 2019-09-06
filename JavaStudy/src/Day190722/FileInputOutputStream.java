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
			//주어진 File 객체가 가리키는 파일을 바이트 스트림으로 읽기 위한 FileInputStream 객체를 생성.
			in = new FileInputStream(new File(strFile01)); 
			//주어진 File 객체가 가리키는 파일을 바이트스트림으로 쓰기 위한 FileOutputStream 객체를 생성.
			//기존의 파일이 존재할 때는 디폴트로 그 내용을 지우고 새로운 파일을 생성(덮어쓴다)
			out = new FileOutputStream(strFile02, append);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		try {
			while((i = in.read()) != -1){ //1byte를 읽어서 
					System.out.println(i); //1byte이므로 한글은 깨짐
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
