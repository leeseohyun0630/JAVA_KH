package model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class test2 {
	public static void main(String[] args) {
		output();
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Socket socket = new Socket(null, 0);
	}
	
	public static void output() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("test.txt", true);
			fw.write(97);
			fw.write(65);
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void client() {
		int port = 3000;
		String serverIP;
		
		try {
			serverIP = "192.168.20.34";
			
			Socket socket = new Socket(serverIP, port);
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

