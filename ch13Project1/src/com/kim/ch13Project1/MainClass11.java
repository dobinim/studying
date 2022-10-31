package com.kim.ch13Project1;

public class MainClass11 {
	static long startTime = 0;

	public static void main(String[] args) {
		Thread11_01 th1 = new Thread11_01();
		Thread11_02 th2 = new Thread11_02();
		
		th1.start();
		th2.start();
		
		startTime = System.currentTimeMillis();

		try {
			th1.join();	// main �����尡 th1�� �۾��� ���� ������ ��ٸ���.
			th2.join();	// main �����尡 th2�� �۾��� ���� ������ ��ٸ���.
		} catch (InterruptedException e) {
			
		}
	
		System.out.print("�ҿ�ð� : " + (System.currentTimeMillis() - startTime));
	
	}

}

class Thread11_01 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class Thread11_02 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("*");
		}
	}
}