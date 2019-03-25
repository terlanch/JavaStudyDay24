package cn.tedu.demo01;
/*
 * �����ߺ�������ģʽ
 * һ������һ������
 * 		
 */
public class ProductDemo {
	public static void main(String[] args) {
		Product p = new Product();
		
		//���������ߺ������ߵ��߳�
			
		new Thread(new Producter(p)).start();
		new Thread(new Producter(p)).start();
		new Thread(new Consumer(p)).start();
		new Thread(new Consumer(p)).start();
	}
}

class Producter implements Runnable{
	private Product p;
	public Producter(Product p) {
		// TODO Auto-generated constructor stub
	this.p = p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//���߲���
		while(true){
			//ͬ�������  ��ס
			synchronized (p) {
				//�������ߺ������߱�� ����������
				while(!p.flag){
					try {
						//��ִ�д���ľ���������
						p.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//�Ȼ�ȡ�ܹ��������������
				int maxCount = 1000 - p.getCount();
				//����������ʵ������
				int count =(int)(Math.random() * (maxCount+1));
				//���ÿ������ѵ�����
				p.setCount(count + p.getCount());
				
				System.out.println("����������ʵ��������"+ count +"�������ѵ�������"+p.getCount());
				
				p.flag = false;
				//�����߳�
				p.notify();
				//��������
				p.notifyAll();
				
			}
		}
	}
}
class Consumer implements Runnable{
	private Product p;
	public Consumer(Product p){
		this.p = p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (p) {
				while(p.flag){
					try {
						
						p.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//��ȡʵ�����ѵ�����
				int count =(int)(Math.random()*(p.getCount()+1));
				//�޸�ʣ�������
				p.setCount((p.getCount() - count));
				
				System.out.println("����ʵ��������"+count+"����ʣ������"+p.getCount());
				p.flag = true;
//				//�����߳�
//				p.notify();
				//��������
				p.notifyAll();
				
			}
		}
	}
	
}
class Product {
	private int count;
	public boolean flag =true;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}