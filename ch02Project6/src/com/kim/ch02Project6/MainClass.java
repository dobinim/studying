package com.kim.ch02Project6;

import java.util.Scanner; 
/* 왜 Scanner 만 import 해주고 system 같은건 안하는가?
 → java.lang 안의 것들은 자유롭게 쓸 수 있어서 굳이 import하지 않음 */

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner; // 콘솔창에서 입력받은 것을 처리하는 클래스 
		scanner = new Scanner(System.in); // 새로운 Scanner 객체 선언
	/* → 이걸 한줄로 줄여쓸 수 있음 
		Scanner scanner = new Scanner(System.in);	
		new는 생성자를 호출하는 키워드 
		생성자 → 특수 메서드. 클래스 이름과 동일한 이름을 가지며, 리턴 타입이 없다 
		in → 입력을 지원하는 변수 */
		
		System.out.print("안내 : 두 자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();
		/* nextLine() 메서드 
		 Enter 치기 전까지 입력한 값을 반환
		 입력한 값을 String 형태로 반환
		 입력 전까지는 대기		 
		 next() 메서드 → 공백을 만나면 입력값을 반환 */
		int num = Integer.parseInt(input); 
		// integer → 자바가 제공하며 정수와 관련된 것을 처리하는 클래스
		// parseint → 문자열 메서드. 문자열로 변경해주는 메서드이며 정수형(int) 문자열만 가능

		System.out.println("입력내용 : " + input);
		System.out.printf("num=%d%n", num);
	}

}
