package com.kim.ch02Project1;

public class Ch02Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, world"); // 화면에 문자열 Hello, world 출력 후 줄바꿈
		System.out.print("Hello, world"); // 화면에 Hello, world 출력 후 줄바꿈 X 
		System.out.print("Hello");
		System.out.println("World");
		
		// system → 시스템에 관련된 모든 java 정보를 갖고 있는 class
		// out → printstream 객체에 관한 설명, 즉, print에 관한 내용을 담고 있는 변수
		// system.out → println 이나 print를 가진 객체

		System.out.println("3+5="); // 3+5라는 식 그 자체를 "문자열" 로 인식해 출력
		System.out.println(3+5); // 3+5의 값을 출력
		
		// 사칙연산 출력
		System.out.println(3+5);  
		System.out.println(3-5);
		System.out.println(5*3);
		System.out.println(5/3); // 정수/정수니까 값도 정수로 나옴. 소숫점까지 나오게 하고 싶으면 5.0 or 3.0 해야함
		System.out.println(5.0/3); 
		
		

	}

}
