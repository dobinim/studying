package com.kim.ch08Project1;

public class MainClass01 {

	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			// try는 예외발생가능성이 있는 코드를 작성하는데 print 문에서는 예외발생 X이므로 catch문 사용 안함
			System.out.println(2);
			System.out.println(3);
		} catch(Exception e) { 
			// Exception 은 예외처리 클래스로, 상위클래스로 이를 상속한 하위클래스를 다형성에 의해 받는다.
			System.out.println(4); // 예외 발생 시 처리할 코드
		}
		
		// try-catch문을 블록 밖에서 수행되는 코드
		System.out.println(5);
	}

}
