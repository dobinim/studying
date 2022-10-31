package com.kim.ch08Project1;

public class QuizClass4 {

	public static void main(String[] args) {
		int age = 0;
		checkAge(age);
	}
	
	static void checkAge(int age) throws ArithmeticException { 
		throw new ArithmeticException();
		
	}
}

/* 4. static void checkAge(int age) { } 메서드에 ArithmeticException 을 
 * 	위임하여 처리하는 메서드를 만든다. (블록 안은 없어도 OK)
 */
 