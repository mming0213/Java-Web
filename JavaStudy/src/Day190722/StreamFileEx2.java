package Day190722;

import java.io.File;

public class StreamFileEx2 {

	public static void main(String[] args) {
		File f = new File("c:/Temp");
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		
		File[] files = f.listFiles(); //
		
		for(int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			//boolean isDirectory() : ���丮���� Ȯ��
			System.out.println(files[i].isDirectory() +"[" + fileName + "]" + fileName);
		}

	}

}
