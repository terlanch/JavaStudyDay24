package cn.tedu.demo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPRevDemo {
	public static void main(String[] args) throws IOException  {
		//创建码头 设置端口
		DatagramSocket ds = new DatagramSocket(12306);
		//创建集装箱
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		System.out.println("准备接收");
		//接收发送过来的数据
		//这一不会造成阻塞
		ds.receive(dp);
		System.out.println("接收到了吗");
		//接收到的数据
		byte[] data  = dp.getData();
		//接收到的实际长度
		int len = dp.getLength();
		System.out.println(new String(data,0,len));//接收的数据
		//获取代表ip的类
		InetAddress inet = dp.getAddress();
		System.out.println(inet.getHostAddress());
		//发送者的端口号
		int port = dp.getPort();
		System.out.println(port);
		//关闭流
		ds.close();
		
	}
}
