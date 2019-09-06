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
			System.out.println("[Server]" + getTime() + "서버가 준비되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println("[Server]" + getTime() + "연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();
				System.out.println("[Server]" + getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice]Test Message1 from Server");
				System.out.println("[Server]" + getTime() + "데이터를 전송했습니다.");
				
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
