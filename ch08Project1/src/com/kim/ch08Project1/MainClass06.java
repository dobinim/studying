package com.kim.ch08Project1;

public class MainClass06 {

	public static void main(String[] args) {
		// 예외는 Exception 계열과 RuntimeException 계열로 구분됨
		Exception e = new Exception();
		// throw e;
		// throw new Exception(); 으로 한번에 처리할 수 있음
		// Exception 예외는 try-catch 로 예외 처리를 하지 않으면 컴파일 에러 발생 (checked 예외)
		
		throw new RuntimeException();
		// 컴파일 에러는 발생하지 X, 프로그램 실행 중 예외 발생(unchecked 예외)
		// 실행중에는 에러가 발생하므로 해당 예외를 처리 
		

	}
}
