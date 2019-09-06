//package Day190723;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Date;
//
//import javax.swing.text.AbstractDocument.BranchElement;
//
//public class BufferedWriter {
//
//	public BufferedWriter(FileWriter fw) {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//		FileReader fr = null;
//		FileWriter fw = null;
//		BufferedReader br = null;
//		BufferedWriter bw = null;
//		
//		Date d = null;
//		try {
//			//"ReadFile.txt" 파일을 읽는 FileReader 객체 생성
//			//BufferedReader 객체 생성
//			fr = new FileReader("C:/Temp/HashSetLotto.java");
//			br = new BufferedReader(fr);
//			
//			//FileWriter로 파일 "CopyFile.txt"에 출력한다. 기존 파일에 덮어쓴다.
//			//BufferedWriter 객체 생성
//			fw = new FileWriter("C:/Temp/CopyFile.txt", false);
//			bw = new BufferedWriter(fw);
//			
//			String s = null;
//			d = new Date();
//			
//			//파일 복사 시작 시간
//			long start = d.getTime();
//			
//			//ReaderFile.txt에서 한줄씩 읽어서 BufferedReader에 저장한다.
//			while((s = br.readLine()) != null) {
//				//읽은 데이터(한줄)을 BufferedWriter에 쓴다.
//				//한줄씩 읽으므로, newLine() 메소드를 줄바꿈을 해준다.
//				//bw.write(s);
//				//bw.newLine();
//			}
//			//복사 완료된 시간을 얻는다.
//			d = new Date();
//			long end = d.getTime();
//			
//			System.out.println("복사 시간: " + (end-start));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			//BufferedReader FileReader를 달아준다.
//			if(br != null) {
//				try {
//					br.close();
//				}catch(IOException e) {}
//			}
//			
//			if(fr != null) {
//				try {
//					fr.close();
//				}catch(IOException e) {}
//			}
//		
//			//BufferedWriter FileWriter를 달아준다.
//			if(bw != null) {
//				try {
//				//	bw.close();
//				}catch(IOException e) {}
//			}
//			
//			if(fw != null) {
//				try {
//					fw.close();
//				}catch(IOException e) {}
//			}
//			
//		}
//
//	}
//
//}
