package com.kim.ch08Project1;

public class MainClass04 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);

	try {
		System.out.println(3);
		System.out.println(0/0);	// ArithmeticException 예외 발생
		System.out.println(4);
	} catch (ArithmeticException ae) {
		ae.printStackTrace();		
		// 예외 담당 Class와 원인(내용), 경로까지 출력
		// 	cf. System.out.println(ae.toString()); → 예외 담당 Class와 원인만 나타내주고, 위치는 X  
		System.out.println("예외메시지 : " + ae.getMessage());
	} 
	
	System.out.println(6);
	}
	
}
