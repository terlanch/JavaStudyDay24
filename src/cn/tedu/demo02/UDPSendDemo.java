package cn.tedu.demo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
	public static void main(String[] args) throws IOException {
		//发送数据
		//创建码头
		DatagramSocket ds = new DatagramSocket();
		
		//创建集装箱
		//参数1 数据的字节数组形式
		//参数2 要发送的数据的长度
		//参数3 发送的IP
		//参数4 发送的端口号
		byte[] bys = "在吗".getBytes();
		DatagramPacket dp =new DatagramPacket(bys, bys.length,InetAddress.getLocalHost(),12306);
		
		//发送数据
		ds.send(dp);
		//关闭码头
		ds.close();
		
	}
		
	
}
