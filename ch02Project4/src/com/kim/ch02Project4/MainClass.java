package com.kim.ch02Project4;

public class MainClass {

	public static void main(String[] args) {
		int x = 10, y = 5;
		// 동일한 데이터 형을 선언할 때 이렇게 한꺼번에 선언할 수도 있음
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		
		int tmp = x; // 두 변수 값을 교환하기 위해 임시 변수 tmp 선언
		x = y; // y의 값을 x에 저장
		y = tmp; // tmp에 저장된 x의 값을 y에 저장
		
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		
	}

}
