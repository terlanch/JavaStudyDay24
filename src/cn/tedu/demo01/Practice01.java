package cn.tedu.demo01;

public class Practice01 {
	
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setName("�ŷ�");
		stu.setGender("С���");
		
		new Thread(new Ask(stu)).start();
		new Thread(new Change(stu)).start();
	}
}
//�л��˵���
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
					//�����̵߳ȴ�
					try {					
							s.wait();				
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(s.getName().equals("�ŷ�")){
					s.setName("����");
					s.setGender("С���");
				}else{
					s.setName("�ŷ�");
					s.setGender("С���");
				}
				s.flag = true;
				//����
				s.notify();
			}
		}
	}
	
}
//��ʾ������
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
					//�ȴ�
					try {
							s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("С��"+",����"+s.getName()+s.getGender()+",����");
				//����
				s.flag = false;
				s.notify();
			}
		
		}
		
	}
}
//�������ѧ����
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