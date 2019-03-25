package cn.tedu.demo01;

public class Practice02 {
	public static void main(String[] args) {
		User  u = new User();
		u.setName("生产者生产了");
		u.setNum((int)(Math.random()*1000));
		
		new Thread(new Work(u)).start();
		new Thread(new Change1(u)).start();
	}
}

class Change1 implements Runnable{
	private User u;
	public Change1(User u){
		this.u = u;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (u) {
				if(!u.flag){
					try {
					Thread.sleep(1);
					u.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			if(u.getName() == "生产者生产了"){
			u.setName("消费者消费了");
			int y = u.getNum();
			int x = (int)(Math.random()*1000);
				if(x < y){
					u.setNum(x);
				}
			int cha = y - x	;
		}else{
			u.setName("生产者生产了");
			
			u.setNum((int)(Math.random()*(1000-u.getNum())));
		}
			u.flag = false;
			u.notify();
		}
			
		}
		
	}
	
}
class Work implements Runnable{
	private User u;
	
	public Work(User u){
		this.u = u;
	}
	@Override
	
	public void run() {
		while(true){
			synchronized (u) {
				if(u.flag){
					try {
						u.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(u.getName()+""+u.getNum()+"个");
				u.flag = true;
				u.notify();
			}
	
		}
	}
}
class User{
	private String name;
	private int num ;
	public boolean flag = true;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}