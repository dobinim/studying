package com.kim.ch13Project1;

// 멀티 스레드로 처리 (메인스레드와 다른 추가 스레드)
// 메인 스레드 실행 , Thread03 실행이 교대로 일어남 → - 와 | 가 번갈아가며 나타남
public class MainClass03 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Thread03 th = new Thread03();
		th.start();
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 300; i++)
			System.out.printf("-");
		
		// System.out.println();		// 띄어쓰기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		System.out.print("소요시간 1 : " + (System.currentTimeMillis() - startTime));
	}
}

class Thread03 extends Thread {
	//Thread 클래스를 상속한 방식으로 스레드 만듬
	@Override
	public void run() {
		for (int i = 0 ; i < 300 ; i++) 
			System.out.printf("%s", new String("|"));
		
		// System.out.println(); 		// 띄어쓰기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		System.out.print("소요시간 2 : " + (System.currentTimeMillis() - MainClass03.startTime));
	}
}
