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

/* 4. static void checkAge(int age) { } �޼��忡 ArithmeticException �� 
 * 	�����Ͽ� ó���ϴ� �޼��带 �����. (��� ���� ��� OK)
 */
 