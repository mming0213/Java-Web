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
			
			System.out.println("[Client]" + "������ �������Դϴ�. ����IP:" + serverIp);
			Socket socket = new Socket(serverIp, 7777);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("[Client]" + "�����κ��� ���� �޼���" + dis.readUTF());
			System.out.println("[Client]" + "������ �����մϴ�.");
			
			dis.close();
			socket.close();
			System.out.println("[Client]" + "������ ����Ǿ����ϴ�.");
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
