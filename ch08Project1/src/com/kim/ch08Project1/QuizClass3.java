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


/* 3. �޽����� "Access denied - You must be at least 18 years old." �� 
* 	ArithmeticException ���ܸ� �߻���Ű��, �� ���ܸ� ó���ϴ� try catch���� �����
*  ���� ó�� �� ����� �޽����� ����ϵ��� �Ѵ�. */