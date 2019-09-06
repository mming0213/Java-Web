package Day190716;

import java.util.StringTokenizer;

public class StringTokenizerTest{

	public static void main(String[] args) {
			StringTokenizer st = new StringTokenizer("This \t is a \n String");
			
			while(st.hasMoreTokens())
				System.out.println(st.nextToken());
			System.out.println("======================================");
			//���ڷ� �־��� ���ڿ��� :�� �����ڷμ� �����Ѵ�.
			String str = "80::95::70:";
			StringTokenizer str2 = new StringTokenizer(str, ":", false);
			int i = 0;
			while(str2.hasMoreTokens()) {
				System.out.println(i+":"+str2.nextToken());
				i++;
			}
			System.out.println("======================================");
			//StringTokenizer�� �����ڳ��� �پ� �ִ� ���(::) ���� ���� ������ ���� ���ϴ� ������ �ִ�.
			String[] result = str.split(":");
			for(int x = 0; x < result.length; x++) {
				System.out.println(x+":"+result[x]);
			}
			System.out.println("======================================");
			//������ spilt�� �������� �����ڰ� ���� �� ó������ ���� => 2���� ���ڸ� �޴� spilt���
	
			String str3 = "81-2-010-1234-5678";
			String[] arr2 = str3.split("-", 4);
			for(int x = 0; x < arr2.length;x++) {
				System.out.println(x+":"+arr2[x]);
			}
	}

}
