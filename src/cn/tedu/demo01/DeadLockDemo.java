package cn.tedu.demo01;
/*
 * 
 * ��������������Ƕ�׵�����֮�以�౻���������
 * ����ʱ��Դ����ʹ����һ��
 * synchronized (p) {
 * 		synchronized (s)
 * }
 * synchronized (s) {
 * 		synchronized (p)
 * }
 * 
 * ������������������ ������ �����Դ��û��ʹ�õ����
 * ����ʱ��Դһ�ζ�û��ʹ��
 */
public class DeadLockDemo {
	//��ӡ��
	static Printer p = new Printer();
	//ɨ����
	static Scaner s = new Scaner();
	public static void main(String[] args) {
		
		//Runnable��ʵ����
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//��ʹ�ô�ӡ��
				synchronized (p) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.print();
					//��ʹ��ɨ����
					synchronized (s) {
						s.scan();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//��ʹ��ɨ����
				synchronized (s) {
					s.scan();
					//ʹ�ô�ӡ��
					synchronized (p) {
						p.print();
					}
				}
			}
		}).start();
	}
}
//��ӡ��
class Printer{
	public void print(){
		System.out.println("��ӡ�����ڴ�ӡ");
	}
}
//ɨ����
class Scaner{
	public void scan(){
		System.out.println("ɨ������ɨ��");
	}
}

