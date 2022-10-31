package com.kim.ch08Project1;

public class MainClass02 {

	public static void main(String[] args) {
		System.out.println(1);

		try {
			System.out.println(0/0); // 수학에서 처리하지 못하는 계산 (ArithmeticException 예외)
			System.out.println(2);  
			// 위에서 예외 발생해서 try블록에서 바로 catch 블록 이동 
			// 		→ 예외 발생한 문장부터 그 이후의 try블록 속 문장은 실행되지 X ! 
		} catch (ArithmeticException ae) {
			// ArithmeticException 클래스 = 산술연산예외를 처리하는 클래스로 java.lang 소속이다.
			// 즉, import 따로 안해줘도 OK!
			System.out.println(3);
		} 
		
		System.out.println(4);

	
		System.out.println(0/0); // 예외처리 X 
		// 예외 ☞ runtime error 이지 compile error 가 아니라서 앞에 x 표시는 안뜸!
		/*	Exception in thread "main" java.lang.ArithmeticException: / by zero
		 at com.kim.ch08Project1.MainClass02.main(MainClass02.java:22) 
		 
		 - main method에서 by zero (0으로 나눠서) java.lang.ArithmeticException에 해당하는
		 	예외가 발생했다는 소리
		 - 위치 : MainClass02.java:22 → MainClass02의 22번째 줄	 */
		System.out.println(5); // 위에서 예외 발생했으니 얘는 실행 X 

		
		

		
		
		
		
		
		
		
		
		
		
	}
}


