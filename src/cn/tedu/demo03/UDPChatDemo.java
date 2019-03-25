package cn.tedu.demo03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPChatDemo {
	public static void main(String[] args) {
		//
		new Thread(new Sender()).start();
		new Thread(new RevDemo()).start();
		//
	}
}

class Sender implements Runnable{
	DatagramSocket ds;
	Scanner sc;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ds = new DatagramSocket();
			sc = new Scanner(System.in);
			while(true){
				//������Ϣ
				String str = sc.nextLine();
				//������װ��
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("10.8.33.121"), 8090);
				//����
				ds.send(dp);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class RevDemo implements Runnable{
	DatagramSocket ds ;
	DatagramPacket dp;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ds = new DatagramSocket(8090);
			dp = new DatagramPacket(new byte[1024], 1024);
			while(true){
				//��������
				ds.receive(dp);
				String strData  = new String(dp.getData(),0,dp.getLength());
				System.out.println("IP:"+dp.getAddress() +"˵��"+ strData);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
