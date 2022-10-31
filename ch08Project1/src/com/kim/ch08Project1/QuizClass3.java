package com.kim.ch08Project1;

public class QuizClass3 {

	

 	public static void main(String[] args) {
 		try {
 			ArithmeticException ae = new ArithmeticException("Access Denied - You must be at least 18 yrs old");
 			throw ae;
 		} catch (ArithmeticException ae) {
 			System.out.println(ae.getMessage());
 		}
 
 
/*		try {
			ArithmeticException ae = new ArithmeticException();
			throw ae;
		} catch (ArithmeticException ae) {
			System.out.println("Access denied - You must be at least 18 years old.");
			ae.printStackTrace();
		} */
	} 
} 


/* 3. 메시지가 "Access denied - You must be at least 18 years old." 인 
* 	ArithmeticException 예외를 발생시키고, 그 예외를 처리하는 try catch문을 만들고
*  예외 처리 시 사용한 메시지를 출력하도록 한다. */