package Day190722;

import java.io.File;

public class StreamFileEx1 {

	public static void main(String[] args) {
		File f = new File("C:/Temp/test.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");//확장자 구분자 위치
		
		System.out.println("경로를 제외한 파일이름-" + f.getName());
		System.out.println("확장자를 제외한 파일이름-" + fileName.substring(0, pos));
		System.out.println("확장자-" + fileName.substring(pos+1)); //java
		
		System.out.println("경로를 포함한 파일이름-" + f.getPath());
		System.out.println("파일의 절대경로 -" + f.getAbsolutePath());
		System.out.println("파일이 속해 있는 디렉토리-" + f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator-"+ File.pathSeparator); //String OS에서 사용한느 파일구분자:윈도우(;), 유닉스(:)
		System.out.println("File.pathSeparatorChar" + File.pathSeparatorChar); //Char OS에서 사용한느 파일구분자:윈도우(;), 유닉스(:)
		System.out.println("File.separator-" + File.separator);//OS에서 사용하는 경로구분자: 윈도우(\), 유닉스(/)
		System.out.println("File.separatorChar-" + File.separatorChar);//OS에서 사용하는 경로구분자: 윈도우(\), 유닉스(/)
		

	}

}
