package com.kim.Ch07Project01;

public class Tv extends Object {
	// 상속하는 클래스가 없어도 기본적으로 object 클래스를 상속하고 있음
	// 멤버 인스턴스 변수
	boolean power; // 기본값 false
	int channel; // 기본값은 0
	
	// static 없으니 인스턴스 멤버 메소드 
	void power() { // power = 메서드 이름, () = 매개변수가 들어가는 곳
		power = !power;
		// return; void에서는 return문 생략 가능
	}
	
	void channelUp() {
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
	
	// 생성자가 명시적으로 보외지 않으므로 기본 생성자가 숨겨져 있음 
	/* 
	   생성자는 클래스 이름과 이름이 같고, 
	   기본 생성자는 파라메터와 블럭에 아무것도 입력X
	   public Tv () {}	
	 */
}
