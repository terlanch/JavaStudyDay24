package cn.tedu.demo01;
/*
 * 线程的优先级
 * 从理论上来说，线程优先级越高，那么抢到资源的概率越大。
 * 但是实际上效果相差的并没有那么明显。优先级相差6档，才能
 * 够有一点点效果。线程的优先级从1-10.
 */
public class PriorityTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestDemo(),"线程1");
		Thread t2 = new Thread(new TestDemo(),"线程2");
		
		//设置优先级
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