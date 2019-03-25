package cn.tedu.demo02;
/*
 * 127.0.0.1（localhost）永远代表的是本地的IP地址
 * 
 * 套接字（插座）：Socket 网络中传输数据的一套机制
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		
//		InetAddress ia= InetAddress.getByName("127.0.0.1");
		InetAddress ia= InetAddress.getLocalHost();
		
		//IP地址
		System.out.println(ia.getHostAddress());
		//域名
		System.out.println(ia.getHostName());
	}
	
}
