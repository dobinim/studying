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
			th1.join();	// main 스레드가 th1의 작업이 끝날 때까지 기다린다.
			th2.join();	// main 스레드가 th2의 작업이 끝날 때까지 기다린다.
		} catch (InterruptedException e) {
			
		}
	
		System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
	
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