package cn.tedu.demo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatSendDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		byte[] bys = str.getBytes();
		DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getLocalHost(), 12345);
		ds.send(dp);
		ds.close();
	}
}
