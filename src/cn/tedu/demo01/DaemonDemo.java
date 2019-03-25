package cn.tedu.demo01;
/*
 * �ػ��߳�
 * ������ػ��߳�ȫ����������ô�ػ��߳̽���
 * Java�г����ػ��̣߳����Ǳ��ػ��߳�
 * GC����һ���ػ��̡߳�
 */
public class DaemonDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Soldier());
		Thread t2 = new Thread(new Soldier());
		Thread t3 = new Thread(new Soldier());
		Thread t4 = new Thread(new Soldier());
		//�����Ƿ����ػ��߳�
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		t4.setDaemon(true);
		
		t1.start();
		t2.start();	
		t3.start();
		t4.start();
		
		for(int i = 100; i > 0;i--){
			Thread.sleep(30);
			System.out.println("Boss����"+ i +"��Ѫ");
		}
	}
}

class Soldier implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 10000;i > 0;i--){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ʿ������"+ i +"��Ѫ");
		}
	}
	
}