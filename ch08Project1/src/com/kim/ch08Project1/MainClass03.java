package com.kim.ch08Project1;

public class MainClass03 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0); // 산술처리 예외 (ArithmeticException) 
			System.out.println(4);	 // 위에서 예외 발생했으니 실행 X → 바로 catch로 넘어감 
		} catch (ArithmeticException ae) {
			if (ae instanceof ArithmeticException) {
				// instanceof 연산자를 이용 → 참조변수 instanceof 클래스명 
				// instanceof 연산자를 이용해 ae가 ArithmeticException의 인스턴스인지 판단
				// 참이므로 아래 문장 실행 
				System.out.println("true");
				// catch문을 처리하면 그 이후의 catch문은 처리되지 않는다.
			}
			System.out.println(ae.toString()); // 예외 담당하는 class와 예외 사유를 출력 
			System.out.println("ArithmeticException");
		} catch (Exception e) {
			// 첫 catch블록에서 이미 예외를 찾았기 때문에 얘는 실행되지 X 
			System.out.println("Exception"); // ArithmeticException 이외의 예외는 여기서 처리
		}
		System.out.println(6);
	}
}
