package com.kim.ch03Project4;

public class MainClass {

	public static void main(String[] args) {
		double d = 85.4; // 8byte 실수형 타입의 double 선언
		int score = (int)d; // 더 큰 범위의 double에서 더 작은 범위의 int로 형변환
		// 실수에서 정수형 int로 형변환 시 소수점 아래는 제거 
		System.out.println("score = " + score);
		System.out.println("d = " + d);
	}

}
