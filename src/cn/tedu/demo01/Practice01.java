package cn.tedu.demo01;

public class Practice01 {
	
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setName("张飞");
		stu.setGender("小哥哥");
		
		new Thread(new Ask(stu)).start();
		new Thread(new Change(stu)).start();
	}
}
//切换人的类
class Change implements Runnable{
	
	private Student s;
	public Change(Student s){
		this.s = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (s) {
				if(s.flag){
					//设置线程等待
					try {					
							s.wait();				
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(s.getName().equals("张飞")){
					s.setName("貂蝉");
					s.setGender("小姐姐");
				}else{
					s.setName("张飞");
					s.setGender("小哥哥");
				}
				s.flag = true;
				//唤醒
				s.notify();
			}
		}
	}
	
}
//表示问问题
class Ask implements Runnable{
	private Student s;
	public Ask(Student s){
		this.s = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			while(true){
			
			synchronized (s) {
				if(!s.flag){
					//等待
					try {
							s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("小谷"+",我是"+s.getName()+s.getGender()+",在吗？");
				//唤醒
				s.flag = false;
				s.notify();
			}
		
		}
		
	}
}
//问问题的学生类
class Student {
	private String name;
	private String gender;
	public boolean flag = true;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
}