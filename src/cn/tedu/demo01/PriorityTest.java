package cn.tedu.demo01;
/*
 * �̵߳����ȼ�
 * ����������˵���߳����ȼ�Խ�ߣ���ô������Դ�ĸ���Խ��
 * ����ʵ����Ч�����Ĳ�û����ô���ԡ����ȼ����6��������
 * ����һ���Ч�����̵߳����ȼ���1-10.
 */
public class PriorityTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestDemo(),"�߳�1");
		Thread t2 = new Thread(new TestDemo(),"�߳�2");
		
		//�������ȼ�
		t1.setPriority(10);
		t2.setPriority(1);
		
		t1.start();
		t2.start();
	}
}

class TestDemo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 9;i < 100;i++){
			System.out.println(Thread.currentThread().getName() + "i =" + i);
		}
	}
	
}