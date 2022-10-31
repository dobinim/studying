package com.kim.ch02Project2;

public class Ch02Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 자동으로 생긴 메서드란 뜻
			//변수의 선언	
		int x = 10; // 정수int 타입의 변수 x 를 선언하고, 거기에 10을 저장
		int y = 5;
		
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		
		//변수의 데이터형
		int z = 100; // 정수형 타입 int → 4byte
		double pi = 3.14; // 실수형 타입 double → 8byte / float → 4byte
		char ch = 'a'; // 문자형 타입 char → ''를 이용해 선언, 2byte
		String str = "abc"; // 참조형 타입 string → ""를 이용해 선언
		
		System.out.println(z);
		System.out.println(pi);
		System.out.println(ch);
		System.out.println(str);
		
	}

}
