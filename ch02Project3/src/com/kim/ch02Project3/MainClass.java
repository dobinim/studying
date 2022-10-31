package com.kim.ch02Project3;

public class MainClass {
	// { } 블록 밖에서 선언되는 변수는 전역변수(global variable)로 기본값을 가진다
	/* 기본값
	 * boolean 은 false, 숫자형(정수·실수형)은 0, char는 'u|0000' (띄어쓰기), 참조형은 null
	 * */
	static int age;
	static String name = "kim";
	static char ch;
	// static method 안에서는 static 변수들만 쓸 수 있기 때문에 
	// 앞에 static 붙여줌
	
	public static void main(String[] args) {
		/* 메서드 안에서 선언하는 변수는 모두 지역변수(local variable)로  
		 선언과 함께 초기화해야 한다 */
	
		System.out.println(age); // age는 기본 값이므로 0
		System.out.println(name);
		System.out.println(ch);
		
		String name1 = "Ja" + "va"; // 문자열 "Ja" 와 "va"를 결합연산자로 결합
		String str = name1 + 8.0; // 문자열 + 숫자 → 숫자를 문자열로 변환해 결합, 즉, name1 + "8.0"
		
		System.out.println(name1);
		System.out.println(str);
		
		System.out.println(7 + " ");
		System.out.println(" " + 7);
		System.out.println(7 + "");
		System.out.println("" + 7);
		System.out.println("" + "");
		System.out.println(7 + 7 + "");
		System.out.println("" + 7 + 7);
	}

}
