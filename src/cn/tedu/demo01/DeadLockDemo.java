package cn.tedu.demo01;
/*
 * 
 * 死锁：由于锁的嵌套导致锁之间互相被锁死的情况
 * 死锁时资源至少使用了一次
 * synchronized (p) {
 * 		synchronized (s)
 * }
 * synchronized (s) {
 * 		synchronized (p)
 * }
 * 
 * 活锁：出现了你让我 我让你 结果资源都没有使用的情况
 * 活锁时资源一次都没有使用
 */
public class DeadLockDemo {
	//打印机
	static Printer p = new Printer();
	//扫描仪
	static Scaner s = new Scaner();
	public static void main(String[] args) {
		
		//Runnable的实现类
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//先使用打印机
				synchronized (p) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.print();
					//再使用扫描仪
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
				//先使用扫描仪
				synchronized (s) {
					s.scan();
					//使用打印机
					synchronized (p) {
						p.print();
					}
				}
			}
		}).start();
	}
}
//打印机
class Printer{
	public void print(){
		System.out.println("打印机正在打印");
	}
}
//扫描仪
class Scaner{
	public void scan(){
		System.out.println("扫描仪在扫描");
	}
}

