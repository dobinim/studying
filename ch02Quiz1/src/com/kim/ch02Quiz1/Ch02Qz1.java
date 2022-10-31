package com.kim.ch02Quiz1;

public class Ch02Qz1 {

	public static void main(String[] args) {
		System.out.println("I am learning Java"); // 문자열은 언제나 "" 안에 넣는다. 
		System.out.println(5*6);
		// 이곳은 한줄 주석입니다
		/* 이곳은 1번째 줄 주석입니다
		 * 이곳은 2번째 줄 주석입니다 */
		int myNum = 5;
		float myFloatNum = 5.99f; // float를 나타내는 접미사 f
		char myLetter = 'D';
		boolean myBool = false; // boolean은 값이 true / false 중 하나 (큰따옴표 안씀)
		String myText = "Hello";
		long myLong = 5000L; // long을 나타내는 접미사 L (대문자!)
		double myDouble = 11.22; // double은 접미사 d가 있으나 생략 가능
		
		System.out.println(myNum);
		System.out.println(myFloatNum);
		System.out.println(myLetter);
		System.out.println(myBool);
		System.out.println(myText);
		System.out.println(myLong);
		System.out.println(myDouble);
		
		// 이클립스에서는 저장 시 자동으로 컴파일해 기계어로 된 .class 파일을 만듬
	}

}
	