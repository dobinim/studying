package com.kim.ch13Project1;

public class MainClass09 {

	public static void main(String[] args) {
		// main메서드에 의해 자손 스레드 th1, th2 생성
		// 그룹과 우선순위 5를 상속함
		Thread09_01 th1 = new Thread09_01();
		Thread09_02 th2 = new Thread09_02();
		th1.start();
		th2.start();
		// main 메서드는 계속 진행
		
		try { 
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.print(" << Main 종료 >> ");

	}

}

class Thread09_01 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300 ; i++) {
			System.out.print("-");
		}
		
		System.out.print("<<th1 종료>>");
	}
}

class Thread09_02 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300 ; i++) {
			System.out.print("*");
		}
		
		System.out.print("<<th2 종료>>");
	}
}
