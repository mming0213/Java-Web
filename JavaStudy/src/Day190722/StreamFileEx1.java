package Day190722;

import java.io.File;

public class StreamFileEx1 {

	public static void main(String[] args) {
		File f = new File("C:/Temp/test.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");//Ȯ���� ������ ��ġ
		
		System.out.println("��θ� ������ �����̸�-" + f.getName());
		System.out.println("Ȯ���ڸ� ������ �����̸�-" + fileName.substring(0, pos));
		System.out.println("Ȯ����-" + fileName.substring(pos+1)); //java
		
		System.out.println("��θ� ������ �����̸�-" + f.getPath());
		System.out.println("������ ������ -" + f.getAbsolutePath());
		System.out.println("������ ���� �ִ� ���丮-" + f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator-"+ File.pathSeparator); //String OS���� ����Ѵ� ���ϱ�����:������(;), ���н�(:)
		System.out.println("File.pathSeparatorChar" + File.pathSeparatorChar); //Char OS���� ����Ѵ� ���ϱ�����:������(;), ���н�(:)
		System.out.println("File.separator-" + File.separator);//OS���� ����ϴ� ��α�����: ������(\), ���н�(/)
		System.out.println("File.separatorChar-" + File.separatorChar);//OS���� ����ϴ� ��α�����: ������(\), ���н�(/)
		

	}

}
