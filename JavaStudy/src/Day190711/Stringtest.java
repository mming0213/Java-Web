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
		//StringBuffer클래스는 변하는 문자열을 다룰때 사용.
		//String 클래스의 객체는 한번 생성되면 그 내용이 변하지 않는 반면에,
		//StringBuffer 클래스의 객체는 한번 생성된 후에도 계속하여 저장하고 있는 문자열의 내용을 변경 할 수 있음.
		StringBuffer sb = new StringBuffer("Hello");
		String s1 = new String(sb);
		System.out.println(s1);//Hello
		
		//3.char charAt(int index)
		String s3 = "Hello";
		char c3 = s3.charAt(1);
		System.out.println(c3);//e
		
		//****이해못함******
		//4.int compareTo(String str) 
		//사전순으로 비교 -1/0/1
		//현재 객체<인자로 넘어온 객체 : return 음수
		//현재 객체 == 인자로 넘어온 객체 : return 0
		//현재 객체 > 인자로 넘어온 객체 : return 양수
		int l = "abo".compareTo("abo");//0
		int l2 ="abo".compareTo("bo");//'a'가 빠져 한자 차이로 다른값이 됌.-1값 리턴(한자리 차이)
		int l3 ="abc".compareTo("c"); //'ab'가 빠져 두자 차이로 다른값이 됌.-2값 리턴(두자리 차이)
		int l4 ="abo".compareTo("aboabo");//"abc"가 두번 반복되었지만 문자열 비교로 봤을 때는 전혀 다른 문자열임.
										  //비교대상 문자열보다 "abc"라는 문자열만큼 3자리가 길어서 -3이라는 값이 리턴. -3값 리턴(3차리 차이) 
		int l5 = "abo".compareTo("aboabod");//-4리턴(4자리 차이)
		int l6 = "bbb".compareTo("aaa");
		int l7 = "b".compareTo("a");
		
		System.out.println("4.사전순으로 비교:"+l+" " + l2 + " " + l3 + " " + l4 + " " + l5 + " " + l6 + " " + l7);
		
		//5.String concat(String str) 
		//문자열 덧붙임
		String s5 = "Hello";
		String ss = s5.concat(" World");
		System.out.println(ss);//Hello World
		
		//6.boolean contains(CharSequence s)
		//지정된 문자열이 포함되었는지 검사
		String s6 = "abcdefg";
		boolean b = s.contains("bc"); //true
		
		//7.boolean endsWith(String suffix) 
		//지정된 문자열로 끝나는지 검사
		String file = "Hello.txt";
		boolean b7 = file.endsWith("txt");
		System.out.println(b7); //true
				
		//8.int indexOf(int ch)
		//문자(ch)가 존재하는 위치(0부터 시작)
		String s8 = "Hello";
		int idx1 = s.indexOf('o');
		System.out.println(idx1); //4
		
		//9.int indexOf(int ch, int pos) 
		//문자(ch)가 존재하는 위치를 pos부터 확인하여 index를 알려줌
		String s9 = "Helleo";
		//int idx9 = s.indexOf('e', 0);//1
		int idx10 = s9.indexOf('e', 2);//-1
		System.out.println("9:"  +"," + idx10);
		
		//10.int indexOf(String str)
		//문자열이 존재하는 위치
		String s10 = "ABCDEFG";
		int idx11 = s10.indexOf("CD");
		System.out.println(idx11); //2
		
		//11.int lastIndexof(int ch)
		//문자를 오른쪽 끝에서 찾아서 위치 리턴
		String s11 = "java.lang.Object";
		int idx12 = s11.lastIndexOf('.');
		System.out.println(idx12); //9 index순서는 왼쪽부터

		//12.String replace(char old, char nw) 
		//old 문자를 nw로 변경
		String s12 = "Hello";
		String s13 = s12.replace('H', 'C');
		System.out.println(s13); //Cello
		
		//13.String replaceAll(String regex, String nw) 
		//전체변경
		String s14 = "AABBAABB";
		String r = s14.replaceAll("BB", "bb");
		System.out.println(r);//AAbbAAbb
		
		//14.String replaceFirst(String regex, String nw) 
		//일치하는 것 중 첫번째 것만 변경
		String sb2 = "AABBAABB";
		String r2 = sb2.replaceFirst("BB", "bb");
		System.out.println(r2); //AAbbAABB
		
		//15.String[] split(String regex)
		//분리자로 나누어 배열을 반환
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		
		//16.String[] split(String argex, int limit
		//분리하되 문자열을 limit수만큼 자른다.
		String animals2 = "dog,cat,bear";
		String[] arr2 = animals2.split(",",2);
		System.out.println(arr2[0]); //dog
		System.out.println(arr2[1]); //cat,bear
		//System.out.println(arr2[2]);
		
		//17.boolean startWith(String prefix)
		//주어진 문자열로 시작하는지 검사
		String s17 = "java.lang.Object";
		boolean b17 = s17.startsWith("java");
		System.out.println(b17); //true
		
		//18.String trim()
		//문자열이 왼쪽, 오른쪽 끝에 있는 공백을 없앤 결과를 반환
		String s18 = "   Hello World  ";
		String s19 = s18.trim();
		System.out.println(s19);//Hello World
		
		//19.static String valueOf(boolean b); char/int/long/float/double/Object 
		//지정된 값을 문자열로 반환
		String b19 = String.valueOf("19.지정된 값을 문자열로 반환:"); //
		System.out.println(b19);
		
		
		//20.static String join(CharSequence arg0, CharSequence… arg1)
		String[] arr3 = {"A","B","C"};
		String s20 = String.join("-", arr3);
		System.out.println(s20);//A-B-C
		
		//--------------------------------------------
		//java.lang.StringBuffer
		//1.StringBuffer(String str)
		StringBuffer sb3 = new StringBuffer("H1");
		System.out.println(sb3); //H1
		
		//2.StringBufer append(boolean b) 
		//기본자료형/char[]/Object/String  문자열 뒤에 붙이기
		StringBuffer sb4 = new StringBuffer("abc");
		sb4.append("abc");
		System.out.println(sb4); //abcabc
		
		//3.char charAt(int index)
		StringBuffer sb5 = new StringBuffer("abc");
		char cc = sb5.charAt(2);
		System.out.println(cc); //c
		
		//4.StringBuffer delete(int start, int end) 
		//start~end 사이의 문자를 제거
		StringBuffer sb6 = new StringBuffer("0123456");
		sb6.delete(0, 2);
		System.out.println(sb6); //23456
		
		//5.StringBuffer deleteCharAt(int index) 
		//지정된 위치의 문자제거
		StringBuffer sb7 = new StringBuffer("0123456");
		sb7.deleteCharAt(3);
		System.out.println(sb7); //012456
		
		//6.StringBuffer insert(int pos, boolean b) 
		//char/char[],double/float/int/long/Object/String 
		//문자열로 변환하여 pos에 추가
		StringBuffer sb8 = new StringBuffer("0123456");
		sb8.insert(4,'.');
		System.out.println(sb8);//0123.456
		
		//7.StringBuffer replace(int start, int end, String  str) 
		//지정된 범위의 문자열을 주어진 문자열로 바꾼다.
		StringBuffer sb9 = new StringBuffer("0123456");
		sb9.replace(3, 3, "AB");//012AB3456
//		sb9.replace(3, 4, "AB");//012AB456
//		sb9.replace(3, 5, "AB");//012AB56
//		sb9.replace(3, 6, "AB");//012AB6
//		sb9.replace(3, 7, "AB");//012AB
		System.out.println(sb9);
		
		//8.StringBuffer reverse()) 
		//문자열 순서를 거꾸로
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
