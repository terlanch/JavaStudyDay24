package cn.tedu.demo02;
/*
 * 127.0.0.1��localhost����Զ������Ǳ��ص�IP��ַ
 * 
 * �׽��֣���������Socket �����д������ݵ�һ�׻���
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		
//		InetAddress ia= InetAddress.getByName("127.0.0.1");
		InetAddress ia= InetAddress.getLocalHost();
		
		//IP��ַ
		System.out.println(ia.getHostAddress());
		//����
		System.out.println(ia.getHostName());
	}
	
}
