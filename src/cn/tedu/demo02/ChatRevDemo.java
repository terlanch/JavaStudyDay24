package cn.tedu.demo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ChatRevDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(12345);
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		System.out.println("׼������");
		ds.receive(dp);
		System.out.println("���յ�����");
		byte[] data  = dp.getData();
		//���յ���ʵ�ʳ���
		int len = dp.getLength();
		System.out.println(new String(data,0,len));
		InetAddress inet = dp.getAddress();
		int port = dp.getPort();
		ds.close();
	}
}
