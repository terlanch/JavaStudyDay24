package cn.tedu.demo01;
/*
 * 生产者和消费者模式
 * 一个生产一个消费
 * 		
 */
public class ProductDemo {
	public static void main(String[] args) {
		Product p = new Product();
		
		//开启生产者和消费者的线程
			
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
		//无线产生
		while(true){
			//同步代码块  锁住
			synchronized (p) {
				//给生产者和消费者标记 让他们轮流
				while(!p.flag){
					try {
						//不执行代码的就让他等着
						p.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//先获取能够生产的最大数量
				int maxCount = 1000 - p.getCount();
				//计算生产的实际数量
				int count =(int)(Math.random() * (maxCount+1));
				//设置可以消费的数量
				p.setCount(count + p.getCount());
				
				System.out.println("本次生产的实际数量是"+ count +"，可消费的数量是"+p.getCount());
				
				p.flag = false;
				//唤醒线程
				p.notify();
				//唤醒所有
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
				//获取实际消费的数量
				int count =(int)(Math.random()*(p.getCount()+1));
				//修改剩余的数量
				p.setCount((p.getCount() - count));
				
				System.out.println("本次实际消费了"+count+"本次剩余数量"+p.getCount());
				p.flag = true;
//				//唤醒线程
//				p.notify();
				//唤醒所有
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