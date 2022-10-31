package com.kim.ch08Project1;

public class MainClass10 {

	public static void main(String[] args) {
		 try {
			 startInstall();	// 프로그램 설치에 필요한 준비
			 copyFiles();		// 파일 복사
		 } catch (SpaceException e) {
			 System.out.println("에러 메시지 : " + e.getMessage());
			 e.printStackTrace();
			 System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다.");
		 } catch (MemoryException me) {
			 System.out.println("에러 메시지 : " + me.getMessage());
			 me.printStackTrace();
			 System.gc();		// Garbage Collection을 수행해 메모리를 늘린다
			 System.out.println("설치를 다시 시도하세요.");
		 } finally {
			 deleteTempFiles();	// 프로그램 설치에 사용된 임시파일 삭제
		 } // try-catch-finally 의 끝
	}	// main 끝

	static void startInstall() throws SpaceException, MemoryException {
		// 예외 발생 시 개발자가 만든 SpaceExcetion, MemoryException을 main 메서드에서 처리하게 함
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");}
		// 개발자가 만든 예외를 발생시켜 던져줌
	}

	static void deleteTempFiles() {	}

	static void copyFiles() { }
	
	static boolean enoughSpace() {
		return false;
	}
	
	static boolean enoughMemory() {
		return true;
	}
}	// exception 클래스의 끝


//JDK의 예외 처리 클래스를 상속하는 개발자 정의 예외 처리 클래스
class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg); 	// 예외 내용의 메시지를 가진 예외 인스턴스를 만듬
	}
}
//JDK의 예외 처리 클래스를 상속하는 개발자 정의 예외 처리 클래스 
class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}