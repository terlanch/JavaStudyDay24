package cn.tedu.demo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
	public static void main(String[] args) throws IOException {
		//��������
		//������ͷ
		DatagramSocket ds = new DatagramSocket();
		
		//������װ��
		//����1 ���ݵ��ֽ�������ʽ
		//����2 Ҫ���͵����ݵĳ���
		//����3 ���͵�IP
		//����4 ���͵Ķ˿ں�
		byte[] bys = "����".getBytes();
		DatagramPacket dp =new DatagramPacket(bys, bys.length,InetAddress.getLocalHost(),12306);
		
		//��������
		ds.send(dp);
		//�ر���ͷ
		ds.close();
		
	}
		
	
}
