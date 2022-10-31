package com.kim.ch08Project1;

public class MainClass07 {

	public static void main(String[] args) throws Exception {
		// throws exception은 예외처리를 main을 호출한 곳으로 위임(jvm)
		method1();
	}

	static void method1() throws Exception {
		method2(); // 여기도 try-catch문 없으니 상위 메서드에 위임 (main)
	}
	
	static void method2() throws Exception {
		throw new Exception();
		// 고의로 Exception 예외를 발생시켰으나 try-catch가 아닌 throws로 예외를 
		// 자기를 호출한 메서드에 위임 (method1) 
	}

	/* 출력되는 예외 코드
	 Exception in thread "main" java.lang.Exception
	at com.kim.ch08Project1.MainClass07.method2(MainClass07.java:15)
	at com.kim.ch08Project1.MainClass07.method1(MainClass07.java:11)
	at com.kim.ch08Project1.MainClass07.main(MainClass07.java:7)
			→ 서로 자기를 호출한 상위 클래스에 위임하다가 main에서 끝남
	 */
}
