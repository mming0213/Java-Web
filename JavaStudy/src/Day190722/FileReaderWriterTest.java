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
			//주어진 File 객체를 이용하여 FileReader 객체를 생성.
			//파일에 저장된 byte를 유니코드 문자로 변환하여 읽어 들입니다.
			in = new FileReader(new File(strFile01));
			//주어진 파일명을 열어 FileReader 객체를 생성.
			//출력할 유니코드 문자열을 시스템에 맞는 디폴트 문자 인코딩의 byte로 변환하여 파일에 저장한다.
			out = new FileWriter(strFile02, append);
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
