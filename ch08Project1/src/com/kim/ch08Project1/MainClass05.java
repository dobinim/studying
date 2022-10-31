package com.kim.ch08Project1;

public class MainClass05 {

	public static void main(String[] args) {
		// 고의적 예외 발생 → try 블록 안에서!
		try {
			Exception e = new Exception("고의로 발생시켰음.");
			// 예외 발생 시 메시지를 넣어주는 생성자를 사용해 예외 인스턴스를 만듬
			// java의 해당 클래스 등의 설명을 보려면 클래스 선택 후 shift + F2  
			throw e; // throw 키워드를 이용해 던지면(예외 발생) 해당 catch 블록이 받아서 처리
		} catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		} finally { 	// try-catch문과 관계 없이 마지막에 무조건 거치는 부분임.
			System.out.println("finally"); 
		}
		
		System.out.println("프로그램이 정상 종료되었음.");
	}

} 
