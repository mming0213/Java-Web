package Day190722;

import java.io.File;

public class StreamFileEx2 {

	public static void main(String[] args) {
		File f = new File("c:/Temp");
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		File[] files = f.listFiles(); //
		
		for(int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			//boolean isDirectory() : 디렉토리인지 확인
			System.out.println(files[i].isDirectory() +"[" + fileName + "]" + fileName);
		}

	}

}
