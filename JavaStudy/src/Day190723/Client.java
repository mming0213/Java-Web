package Day190723;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.rmi.ConnectException;

public class Client {

	public static void main(String[] args) {
		try {
			String serverIp = "192.168.0.45";
			
			System.out.println("[Client]" + "서버에 연결중입니다. 서버IP:" + serverIp);
			Socket socket = new Socket(serverIp, 7777);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("[Client]" + "서버로부터 받은 메세지" + dis.readUTF());
			System.out.println("[Client]" + "연결을 종료합니다.");
			
			dis.close();
			socket.close();
			System.out.println("[Client]" + "연결이 종료되었습니다.");
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
