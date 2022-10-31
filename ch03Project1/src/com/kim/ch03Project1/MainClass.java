package com.kim.ch03Project1;

public class MainClass {

	public static void main(String[] args) {
		int x, y; // 정수 타입의 x, y 선언 (지역변수, 4byte)
		x = y = 3; // y에 3 대입하고, y의 값을 x에 대입 
		
		System.out.println("x = " + x); // 이때의 + 는 연결 연산자
		System.out.println("y = " + y);
	}

}
