package com.kim.ch03Project3;

public class MainClass {

	public static void main(String[] args) {
		int i = -10; // 변수를 선언할 때 대이터의 변수이름 = 초기값
		i = +i; // i의 부호를 +로 바꿔라 (*1)
		System.out.println(i);
		
		i = -10; // 값 대입
		i = -i; // i의 부호를 -로 바꿔라 (*-1)
		System.out.println(i);
	}

}
