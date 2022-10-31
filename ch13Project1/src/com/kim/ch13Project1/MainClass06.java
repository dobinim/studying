package com.kim.ch13Project1;

public class MainClass06 {

	public static void main(String[] args) {
		Thread06_1 th1 = new Thread06_1();
		Thread06_2 th2 = new Thread06_2();
		// Main스레드의 우선순위는 기본이 5이다. NORM_PRIORITY
		// main스레드가 th1, th2 스레드를 만들어 5를 상속
		
		th2.setPriority(7);	// th2의 우선순위를 7로 변경
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		// windows os가 cpu타임을 설정하기 때문에 우선순위가 꼭 지켜지는 것은 아니다.
	}
}
	

class Thread06_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300 ; i++) {
			System.out.print("-");
			for (int x = 0; x < 10000000; x++); 	// 	{ } 생략 가능
		}
	}
}


class Thread06_2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300 ; i++) {
			System.out.print("|");
			for (int x = 0; x < 10000000; x++);
		}
	}
}
