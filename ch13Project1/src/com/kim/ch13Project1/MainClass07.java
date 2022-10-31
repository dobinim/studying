package com.kim.ch13Project1;

public class MainClass07 {
// ThreadGroup
// ThreadGroup ��ü�� ����� 
	
	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		// ThreadGroup�� �����ڸ� �̿��� ����
		WorkThread workThreadA = new WorkThread(myGroup, "WorkThreadA");
		// workThreadA ������� ������׷��� myGroup�̰�, ������ �̸��� workThreadA
		WorkThread workThreadB = new WorkThread(myGroup, "WorkThreadB");
		workThreadA.start();
		workThreadB.start();
		
		System.out.println(" [Main ������ �׷��� list() �޼��� ��� ����]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		// ���� ������ main�������� ������׷��� �� - ����Ʈ �޼����!
		mainGroup.list(); // ������׷��� ������ ����ϴ� �޼����,
		// ���� �޼����� ������ �׷��� �ڽ��� myGroup�� �����Ѵ� 
		System.out.println();
		
		myGroup.list();		// myGroup�ڽŸ� ���
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("[MyGroup ������ �׷��� interrupt()�޼��� ȣ��]");
		myGroup.interrupt();	// myGroup�� ���� ��������� �ߴ��� ���� (���� �߻� �� sleep �ߴ�)	
		
	}

}


class WorkThread extends Thread {
	public WorkThread (ThreadGroup threadGroup, String threadName) {
		// ������
		super (threadGroup, threadName); //thread ������
	}

	@Override
	public void run() {
		while(true) {
			try { 
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(getName() + " interrupted");
				break;
			}
			
		}
		System.out.println(getName() + "�����");
	}
}
	
