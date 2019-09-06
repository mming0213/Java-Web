package Day190723;

import java.net.*;
import java.io.*;
import java.util.*;

class ClientSender extends Thread{
	Socket socket;
	DataOutputStream out;
	String name;
	
	ClientSender(Socket socket, String name){
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			this.name = name;
		}catch(Exception e) {
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			if(out != null) {
				out.writeUTF(name);
			}
			
			while(out != null) {
				out.writeUTF("[" + name + "]" + scanner.nextLine());
			}
		}catch(IOException e) {
		}
	}
}

class ClientReceiver extends Thread{
	Socket socket;
	DataInputStream in;
	
	ClientReceiver(Socket socket){
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		}catch(IOException e) {
		}
	}
	
	 public void run() {
	      while(in != null) {
	         try {
	            System.out.println(in.readUTF());
	         }catch(IOException e) {
	            
	         }
	      }
	     }//run

}


public class TcpIpMultichatClient {

	
	public static void main(String[] args) {
		String chatName = "염민주";
		
		try {
			String serverIp = "192.168.0.45";
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new Thread(new ClientSender(socket, chatName));
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start();
			receiver.start();
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(Exception e) {
		}

	}

}
