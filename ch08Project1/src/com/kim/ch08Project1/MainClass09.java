package com.kim.ch08Project1;

public class MainClass09 {

	public static void main(String[] args) {
		try {
			method1();
		} 
		catch(Exception e) {
			System.out.println("main메서드에서 예외가 처리되었습니다.");
		}
	}

	static void method1() throws Exception {		// 호출한 메서드로 Exception 예외처리 위임
		try {
			// 예외처리를 위임했으나 자신도 예외처리함 (재처리)
			throw new Exception();
		} 
		catch (Exception e) {
			System.out.println("method1 메서드에서 예외가 처리되었습니다.");
			throw e; 
		}
	}
}
