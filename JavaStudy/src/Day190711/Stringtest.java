package Day190711;

import java.util.Arrays;

public class Stringtest {

	public static void main(String[] args) {
		//java.lang.String
		
		//1.String(char[] value)
		char[] c = {'H','e','l','l','o'};
		String s = new String(c);
		System.out.println(s);//Hello

		//2.String(StringBuffer buf)
		//StringBufferŬ������ ���ϴ� ���ڿ��� �ٷ궧 ���.
		//String Ŭ������ ��ü�� �ѹ� �����Ǹ� �� ������ ������ �ʴ� �ݸ鿡,
		//StringBuffer Ŭ������ ��ü�� �ѹ� ������ �Ŀ��� ����Ͽ� �����ϰ� �ִ� ���ڿ��� ������ ���� �� �� ����.
		StringBuffer sb = new StringBuffer("Hello");
		String s1 = new String(sb);
		System.out.println(s1);//Hello
		
		//3.char charAt(int index)
		String s3 = "Hello";
		char c3 = s3.charAt(1);
		System.out.println(c3);//e
		
		//****���ظ���******
		//4.int compareTo(String str) 
		//���������� �� -1/0/1
		//���� ��ü<���ڷ� �Ѿ�� ��ü : return ����
		//���� ��ü == ���ڷ� �Ѿ�� ��ü : return 0
		//���� ��ü > ���ڷ� �Ѿ�� ��ü : return ���
		int l = "abo".compareTo("abo");//0
		int l2 ="abo".compareTo("bo");//'a'�� ���� ���� ���̷� �ٸ����� ��.-1�� ����(���ڸ� ����)
		int l3 ="abc".compareTo("c"); //'ab'�� ���� ���� ���̷� �ٸ����� ��.-2�� ����(���ڸ� ����)
		int l4 ="abo".compareTo("aboabo");//"abc"�� �ι� �ݺ��Ǿ����� ���ڿ� �񱳷� ���� ���� ���� �ٸ� ���ڿ���.
										  //�񱳴�� ���ڿ����� "abc"��� ���ڿ���ŭ 3�ڸ��� �� -3�̶�� ���� ����. -3�� ����(3���� ����) 
		int l5 = "abo".compareTo("aboabod");//-4����(4�ڸ� ����)
		int l6 = "bbb".compareTo("aaa");
		int l7 = "b".compareTo("a");
		
		System.out.println("4.���������� ��:"+l+" " + l2 + " " + l3 + " " + l4 + " " + l5 + " " + l6 + " " + l7);
		
		//5.String concat(String str) 
		//���ڿ� ������
		String s5 = "Hello";
		String ss = s5.concat(" World");
		System.out.println(ss);//Hello World
		
		//6.boolean contains(CharSequence s)
		//������ ���ڿ��� ���ԵǾ����� �˻�
		String s6 = "abcdefg";
		boolean b = s.contains("bc"); //true
		
		//7.boolean endsWith(String suffix) 
		//������ ���ڿ��� �������� �˻�
		String file = "Hello.txt";
		boolean b7 = file.endsWith("txt");
		System.out.println(b7); //true
				
		//8.int indexOf(int ch)
		//����(ch)�� �����ϴ� ��ġ(0���� ����)
		String s8 = "Hello";
		int idx1 = s.indexOf('o');
		System.out.println(idx1); //4
		
		//9.int indexOf(int ch, int pos) 
		//����(ch)�� �����ϴ� ��ġ�� pos���� Ȯ���Ͽ� index�� �˷���
		String s9 = "Helleo";
		//int idx9 = s.indexOf('e', 0);//1
		int idx10 = s9.indexOf('e', 2);//-1
		System.out.println("9:"  +"," + idx10);
		
		//10.int indexOf(String str)
		//���ڿ��� �����ϴ� ��ġ
		String s10 = "ABCDEFG";
		int idx11 = s10.indexOf("CD");
		System.out.println(idx11); //2
		
		//11.int lastIndexof(int ch)
		//���ڸ� ������ ������ ã�Ƽ� ��ġ ����
		String s11 = "java.lang.Object";
		int idx12 = s11.lastIndexOf('.');
		System.out.println(idx12); //9 index������ ���ʺ���

		//12.String replace(char old, char nw) 
		//old ���ڸ� nw�� ����
		String s12 = "Hello";
		String s13 = s12.replace('H', 'C');
		System.out.println(s13); //Cello
		
		//13.String replaceAll(String regex, String nw) 
		//��ü����
		String s14 = "AABBAABB";
		String r = s14.replaceAll("BB", "bb");
		System.out.println(r);//AAbbAAbb
		
		//14.String replaceFirst(String regex, String nw) 
		//��ġ�ϴ� �� �� ù��° �͸� ����
		String sb2 = "AABBAABB";
		String r2 = sb2.replaceFirst("BB", "bb");
		System.out.println(r2); //AAbbAABB
		
		//15.String[] split(String regex)
		//�и��ڷ� ������ �迭�� ��ȯ
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		
		//16.String[] split(String argex, int limit
		//�и��ϵ� ���ڿ��� limit����ŭ �ڸ���.
		String animals2 = "dog,cat,bear";
		String[] arr2 = animals2.split(",",2);
		System.out.println(arr2[0]); //dog
		System.out.println(arr2[1]); //cat,bear
		//System.out.println(arr2[2]);
		
		//17.boolean startWith(String prefix)
		//�־��� ���ڿ��� �����ϴ��� �˻�
		String s17 = "java.lang.Object";
		boolean b17 = s17.startsWith("java");
		System.out.println(b17); //true
		
		//18.String trim()
		//���ڿ��� ����, ������ ���� �ִ� ������ ���� ����� ��ȯ
		String s18 = "   Hello World  ";
		String s19 = s18.trim();
		System.out.println(s19);//Hello World
		
		//19.static String valueOf(boolean b); char/int/long/float/double/Object 
		//������ ���� ���ڿ��� ��ȯ
		String b19 = String.valueOf("19.������ ���� ���ڿ��� ��ȯ:"); //
		System.out.println(b19);
		
		
		//20.static String join(CharSequence arg0, CharSequence�� arg1)
		String[] arr3 = {"A","B","C"};
		String s20 = String.join("-", arr3);
		System.out.println(s20);//A-B-C
		
		//--------------------------------------------
		//java.lang.StringBuffer
		//1.StringBuffer(String str)
		StringBuffer sb3 = new StringBuffer("H1");
		System.out.println(sb3); //H1
		
		//2.StringBufer append(boolean b) 
		//�⺻�ڷ���/char[]/Object/String  ���ڿ� �ڿ� ���̱�
		StringBuffer sb4 = new StringBuffer("abc");
		sb4.append("abc");
		System.out.println(sb4); //abcabc
		
		//3.char charAt(int index)
		StringBuffer sb5 = new StringBuffer("abc");
		char cc = sb5.charAt(2);
		System.out.println(cc); //c
		
		//4.StringBuffer delete(int start, int end) 
		//start~end ������ ���ڸ� ����
		StringBuffer sb6 = new StringBuffer("0123456");
		sb6.delete(0, 2);
		System.out.println(sb6); //23456
		
		//5.StringBuffer deleteCharAt(int index) 
		//������ ��ġ�� ��������
		StringBuffer sb7 = new StringBuffer("0123456");
		sb7.deleteCharAt(3);
		System.out.println(sb7); //012456
		
		//6.StringBuffer insert(int pos, boolean b) 
		//char/char[],double/float/int/long/Object/String 
		//���ڿ��� ��ȯ�Ͽ� pos�� �߰�
		StringBuffer sb8 = new StringBuffer("0123456");
		sb8.insert(4,'.');
		System.out.println(sb8);//0123.456
		
		//7.StringBuffer replace(int start, int end, String  str) 
		//������ ������ ���ڿ��� �־��� ���ڿ��� �ٲ۴�.
		StringBuffer sb9 = new StringBuffer("0123456");
		sb9.replace(3, 3, "AB");//012AB3456
//		sb9.replace(3, 4, "AB");//012AB456
//		sb9.replace(3, 5, "AB");//012AB56
//		sb9.replace(3, 6, "AB");//012AB6
//		sb9.replace(3, 7, "AB");//012AB
		System.out.println(sb9);
		
		//8.StringBuffer reverse()) 
		//���ڿ� ������ �Ųٷ�
		StringBuffer sb10 = new StringBuffer("0123456");
		sb10.reverse();//6543210
		System.out.println(sb10);
		
		//9.String substring(int start)
		//String  substring(int start, int end)
		StringBuffer sb11 = new StringBuffer("0123456");
		String str = sb11.substring(3);
		System.out.println(str); //3456
		String str2 = sb11.substring(3,5);
		System.out.println(str2); //34
		
	}

}
