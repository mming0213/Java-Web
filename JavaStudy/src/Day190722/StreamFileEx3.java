package Day190722;

import java.io.File;
import java.util.ArrayList;

public class StreamFileEx3 {

	static int totalFiles = 0;
	static int totalDirs = 0;
	
	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath()+" 디렉토리");
		File[] files = dir.listFiles(); //dir 내부 파일목록(디렉토리 포함)
		
		ArrayList subDir = new ArrayList();
		
		//내부 파일목록 출력
		for(int i = 0; i < files.length; i++) {
			String filename = files[i].getName();
			
			if(files[i].isDirectory()) { //디렉토리인지 확인
				filename = "[" + filename + "]"; //디렉토리이면 []로 표시
				subDir.add(i+"");
			}
			System.out.println(filename);
		}
		
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;
		
		totalFiles += fileNum;
		totalDirs += dirNum;
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();
		
		for(int i = 0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]); //디렉토리인 것에 대해 재귀호출
		}
		

		
	}
	
	public static void main(String[] args) {
		File dir = new File("c:/Temp");
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		printFileList(dir); //디렉토리내 파일 수 리턴

		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
	}

}
