package cn.tedu.demo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPRevDemo {
	public static void main(String[] args) throws IOException  {
		//������ͷ ���ö˿�
		DatagramSocket ds = new DatagramSocket(12306);
		//������װ��
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		System.out.println("׼������");
		//���շ��͹���������
		//��һ�����������
		ds.receive(dp);
		System.out.println("���յ�����");
		//���յ�������
		byte[] data  = dp.getData();
		//���յ���ʵ�ʳ���
		int len = dp.getLength();
		System.out.println(new String(data,0,len));//���յ�����
		//��ȡ����ip����
		InetAddress inet = dp.getAddress();
		System.out.println(inet.getHostAddress());
		//�����ߵĶ˿ں�
		int port = dp.getPort();
		System.out.println(port);
		//�ر���
		ds.close();
		
	}
}
