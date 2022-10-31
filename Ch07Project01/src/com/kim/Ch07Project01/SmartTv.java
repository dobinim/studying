package com.kim.Ch07Project01;

// extends 키워드를 사용해 Tv 클래스를 상속
// Tv는 Parent 클래스이고 SmartTv는 Child 클래스이다

public class SmartTv extends Tv {
	// Tv 클래스를 (Object 클래스가 포함됨)를 상속
	// 상속은 멤버변수, 멤버메서드만 상속하고 생성자와 초기화블록은 제외
	// Tv클래스의 멤버변수에 추가해 사용할 멤버 변수
	boolean caption;
	// Tv 클래스의 멤버메서드에 추가해 사용할 멤버 메서드
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
	
	// 기본 생성자는 명시적으로 표기 X → 묵시적으로 표기되어 있음
	// SmartTv() {}
}
