package com.kim.ch13Project1;

public class MainClass01 {
	
	public static void main(String[] args) {
		Thread01 t1 = new Thread01();
		// Thread 클래스를 상속한 클래스의 인스턴스 (즉, 쓰레드 객체)는 클래스의 생ㅅ어자로 만든다
		t1.start(); // thread 시작 run 메서드 생성
		
		// runnable을 구현한 클래스의 thread 객체
		Runnable r = new Thread02(); // 구현한 클래스를 이용해 Runnable 인터페이스의 객체 생성
		Thread t2 = new Thread(r);	 // Thread의 생성자 중 매개변수가 Runnable로 된 생성자 이용 
		t2.start();					 // Thread02의 run() 호출
		System.out.println("main thread");
	}

}

class Thread01 extends Thread { 
	//	java.lang에 속한 기본 클래스
	//	public class Thread extends Object implements Runnable
	//	Thread 작업을 처리하는 run 메서드를 재정의하여ㅏ 쓰레드가 할 일을 정의
	@Override
	public void run() {
		System.out.println(getName());
		// 상위클래스에서 상속한 getName()은 Thread의 이름을 반환
		// Thread 이름은 순서대로 (기본형) Thread-0 형태로 주어진다
	}
}

class Thread02 implements Runnable {
	//java.lang에 있는 인터페이스
	// @FunctionalInterface public interface Runnable 추상 메서드가 하나만 있는 메서드
	@Override
	public void run() {
		for(int i = 0; i <5 ; i++ ) {
			System.out.println(Thread.currentThread().getName());
			// Thread 클래스의 static메서드 currentThread()는 현재 실행중인 Thread 객체를 반환
		}
	}
}