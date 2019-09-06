//package Day190723;
//
//import java.io.FileOutputStream;
//import java.io.ObjectOutput;
//
//public class ObjectInputOutputTest2 {
//
//	public static void main(String[] args) {
//		ObjectData[] date = new ObjectData[3];
//		data[0] = new ObjectData("Yongwoo", 26, 168f);
//		data[1] = new ObjectData("Kildong", 26, 174.8f);
//		data[2] = new ObjectData("Dongsoo", 30, 169.4f);
//
//		try {
//			FileOutputStream outf = new FileOutputStream("AaTxtTest.txt");
//			ObjectOutput out = new ObjectOutput(outf);
//			out.writeInt(data.length);
//			System.out.println("Number:" + data.length);
//			//Object 개수만큼 Object를 출력한다.
//			for(int i = 0; i < data.length; i++) {
//				out.writeObject(data[i]);
//				System.out.println(data[i]);
//			}
//			out.close();
//			FileInputStream inf = new FileInputStream("FileInputStream");
//			ObjectInput in = new ObjectInput(inf);
//			int numberOfData;
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
