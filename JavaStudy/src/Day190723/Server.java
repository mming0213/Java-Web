package Day190723;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.Date;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("[Server]" + getTime() + "������ �غ�Ǿ����ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println("[Server]" + getTime() + "�����û�� ��ٸ��ϴ�.");
				Socket socket = serverSocket.accept();
				System.out.println("[Server]" + getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice]Test Message1 from Server");
				System.out.println("[Server]" + getTime() + "�����͸� �����߽��ϴ�.");
				
				dos.close();
				socket.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}
